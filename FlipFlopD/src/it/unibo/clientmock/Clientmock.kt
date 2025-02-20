/* Generated by AN DISI Unibo */ 
package it.unibo.clientmock

import it.unibo.kactor.*
import alice.tuprolog.*
import unibo.basicomm23.*
import unibo.basicomm23.interfaces.*
import unibo.basicomm23.utils.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import it.unibo.kactor.sysUtil.createActor   //Sept2023

//User imports JAN2024

class Clientmock ( name: String, scope: CoroutineScope, isconfined: Boolean=false  ) : ActorBasicFsm( name, scope, confined=isconfined ){

	override fun getInitialState() : String{
		return "s0"
	}
	override fun getBody() : (ActorBasicFsm.() -> Unit){
		//val interruptedStateTransitions = mutableListOf<Transition>()
		return { //this:ActionBasciFsm
				state("s0") { //this:State
					action { //it:State
						CommUtils.outred("$name STARTS")
						forward("set1", "set1(1)" ,"ffdcircuit" ) 
						delay(5000) 
						forward("set0", "set0(1)" ,"ffdcircuit" ) 
						delay(5000) 
						forward("reset1", "reset1(1)" ,"ffdcircuit" ) 
						delay(5000) 
						forward("reset0", "reset0(1)" ,"ffdcircuit" ) 
						delay(5000) 
						//genTimer( actor, state )
					}
					//After Lenzi Aug2002
					sysaction { //it:State
					}	 	 
				}	 
			}
		}
} 
