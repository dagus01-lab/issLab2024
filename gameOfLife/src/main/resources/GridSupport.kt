package main.resources

import it.unibo.kactor.ActorBasic
import it.unibo.kactor.CoapObserverSupport
import it.unibo.kactor.sysUtil
import org.json.simple.JSONObject
import org.json.simple.parser.JSONParser
import unibo.basicomm23.utils.CommUtils
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.util.*
import org.eclipse.californium.core.*

object GridSupport{
	private val cellsList:MutableList<String> = ArrayList()
	public lateinit var conf: GOLConfig
	
	@JvmStatic fun initGame(fileName: String, a: ActorBasic): Int{
		conf = GOLConfigReader.loadGOLConfig(fileName)
		for( i in 0 until conf.rows){
			for( j in 0 until conf.columns){
				var cellName = createCell(i, j, a)
				cellsList.add(cellName)
			}
		}
		return cellsList.size
	}
	@JvmStatic fun createCell(i:Int, j:Int, a: ActorBasic): String{
		var nextSuffix = "c_${i}_${j}"
		return a.createActorDynamically("cell", nextSuffix, false)
	}
	 @JvmStatic fun observeAllCells(a: ActorBasic, ctx : String, msgid: String="cellUpdate" ) {
        CommUtils.outcyan("observeAllCells cellsList $cellsList")  
        val cells=cellsList?.listIterator()
        while( cells!!.hasNext() ) {
            val name  = cells!!.next().toString()//"cell${cells!!.next().toString()}"
            //CommUtils.outcyan("observeAllCells $name")  
            CoapObserverSupport(a, "localhost", "8050", ctx, name, msgid)  //Trasforma update in msg
        }
    }
	 @JvmStatic fun observeNeighborCells(a: ActorBasic, ctx : String, msgid: String="cellUpdate") : Int{
		var row = a.name.split("_")[1].toInt()
		var col = a.name.split("_")[2].toInt()
        val cells=cellsList?.listIterator()
		val neighborsCells = genNeighborsNames(row, col)
        while( cells!!.hasNext() ) {
			var nextCell = cells!!.next()
			if(neighborsCells!!.contains(nextCell.toString())){
				val name  = "${nextCell.toString()}"
	            CommUtils.outcyan("observeNeighborCells $name")
	            CoapObserverSupport(a, "localhost", "8050", ctx, name, msgid)  //Trasforma update in msg
			}
        }
		 return neighborsCells!!.size
    }
	@JvmStatic  fun genNeighborsNames(x: Int, y: Int): List<String>? {
        val result : MutableList<String> = ArrayList()
        for (i in -1..1) {
            for (j in -1..1) {
                if ( (i == 0) and (j == 0) ) continue
                val x1 = x + i
                val y1 = y + j
                if (x1 >= 0 && x1 < conf.rows && y1 >= 0 && y1 < conf.columns) {
                    val cell = "cellc_${x1}_${y1}"
                    result.add(cell)
                }
            }
        }
        return result
    }
}