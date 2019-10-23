#define SOCKET_ERROR -1
#define INVALID_SOCKET -1
#include <stdbool.h>
#include <stdlib.h>
#include <stdio.h>
#include <sys/socket.h> // Methode sock
#include <unistd.h>    // close et shutdown
#include <arpa/inet.h> // inet_addr()
#include <netinet/in.h>  // sockaddr_in
#include <string.h>


int TraiterErreur(int param){
    if(param == SOCKET_ERROR){
      perror("Socket :");
      exit(EXIT_FAILURE);
    }else{
        return param;
    }
}


int main(int argc, char const *argv[])
{
   // Declaration
   char buffer[1024]="Hello";
   int sock, sockCom;
   struct sockaddr_in Serv; // socket du serveur
   struct sockaddr_in clientSock; // socket du client
   socklen_t addSize;
   // Initiation d'une socket du serveur
   
   sock = socket(AF_INET,SOCK_STREAM,0);
   TraiterErreur(sock);
   
   Serv.sin_family = AF_INET;
   Serv.sin_addr.s_addr = inet_addr("127.0.0.1");
   Serv.sin_port = htons(1300);
   printf("Structure complet \n");
   
   // Completer la structure de donnée avec des zéros
   bzero(&(Serv.sin_zero),8);
   
   // Lier la socket à @IP et port
   TraiterErreur(bind(sock,(struct sockaddr *)&Serv,sizeof(Serv)));
   printf("Liaison etablie \n");
   
   TraiterErreur(listen(sock,5));
   printf("Serveur on ecoute d'une connexion \n");
               
               
   addSize =  sizeof(clientSock);
   while(true){
                  sockCom = accept(sock,(struct sockaddr *) &clientSock, &addSize);
                  TraiterErreur(sockCom);

                  
                  int octet = send(sockCom,buffer,strlen(buffer),0);

                  printf("J'ai envoyée hello\n");

                  TraiterErreur(octet);     
                  
                  TraiterErreur(close(sockCom));
   }
   return 0;
}

