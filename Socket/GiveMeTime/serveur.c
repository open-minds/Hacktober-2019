#include <sys/types.h>
#include <sys/socket.h>
#include <unistd.h>
#include <arpa/inet.h>
#include <netinet/in.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <time.h>
#include <stdbool.h>

#define SOCKET_ERROR -1
#define PORT 4500

int TraiterErreur(int param){
    if(param == SOCKET_ERROR){
      perror("Socket :");
      exit(EXIT_FAILURE);
    }else{
        return param;
    }
}


int main()
{
   struct sockaddr_in serv,clientSocket;
   socklen_t sizeAddr;
   int sockfd,sockcm;
   char buffer[1024]; 
    
    // Ajoue d'une socket
    sockfd = socket(AF_INET,SOCK_STREAM,0);
    TraiterErreur(sockfd);
    
    printf("Ouverture du socket \n");    
    serv.sin_family= AF_INET;
    serv.sin_addr.s_addr = inet_addr("127.0.0.1");
    serv.sin_port = htons(PORT);
    bzero(&serv.sin_zero,8);
    
    // Bind 
    TraiterErreur(bind(sockfd,(struct sockaddr *)&serv,sizeof(serv)));
    printf("serveur disponible sur @IP %s:%d \n",inet_ntoa(serv.sin_addr),htons(serv.sin_port));
    
    // Listen
    // 1 seule Client TraiterErreur(listen(sockfd,1));
    TraiterErreur(listen(sockfd,5));
    printf("En ecoute ....\n");
    int nbClient = 1;
    while(true){

            //Accept
            sizeAddr = sizeof(clientSocket);
            sockcm = TraiterErreur(accept(sockfd,(struct sockaddr *)&clientSocket,&sizeAddr));
            printf("Client %d connecté à %s:%d \n",nbClient,inet_ntoa(clientSocket.sin_addr),htons(clientSocket.sin_port));
            
            //Recevoir la demande
            TraiterErreur(recv(sockcm,&buffer,sizeof(buffer),0));
            printf("Client à envoyer %s \n",buffer);
            if(strcmp(buffer,"Time") == 0){
            time_t temps = time(NULL);
            printf("Serveur à envoyer le temp au client \n");
            TraiterErreur(send(sockcm,ctime(&temps),sizeof(buffer),0));
            }
            nbClient++;
            printf("\n \n \n");
            TraiterErreur(close(sockcm));
            
    }
    return 0;
}
