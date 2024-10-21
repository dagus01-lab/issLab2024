import socket

def main():
    server_address = '127.0.0.1'
    server_port = 8888

    # Creazione del socket client
    client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

    try:
        # Connessione al server
        client_socket.connect((server_address, server_port))

        # Invia un numero al server
        msg_id = 0
        msg_type = "event" #event, dispatch, request, reply, invitation
        msg_sender = "gabriele_daga"
        dest = server_address+":"+server_port
        n = 10
        msg_num = 0
        client_socket.sendall("msg($msg_id, $msg_type, $msg_sender, $dest, $n, $msg_num)").encode('utf-8')

        # Ricevi la risposta dal server
        data = client_socket.recv(1024)
        ans = data.decode('utf-8')

        print(f"Risposta del server: $ans")

    except Exception as e:
        print(f"Errore durante la connessione al server: {e}")

    finally:
        # Chiudi il socket client
        client_socket.close()

if __name__ == "__main__":
    main()
