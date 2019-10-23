#include <sys/types.h>
#include <sys/socket.h>
#include <unistd.h>
#include <arpa/inet.h>
#include <netinet/in.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>


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
    struct sockaddr_in client;
    int sockfd;
    char *buffer= "Time";
    char receive[1024];
    // Definis socket client
    sockfd = socket(AF_INET,SOCK_STREAM,0);
    TraiterErreur(sockfd);
    printf("Socket ouvert \n");
    
    // Remplir socket client
    client.sin_family = AF_INET;
    client.sin_addr.s_addr = inet_addr("127.0.0.1");
    client.sin_port = htons(PORT);
    bzero(&client.sin_zero,8);
    
    // Connect 
    TraiterErreur(connect(sockfd,(struct sockaddr *)&client,sizeof(client)));
    
    printf("Connecter au serveur  %s:%d \n",inet_ntoa(client.sin_addr),htons(client.sin_port));
    printf("Requet %s\n",buffer);
    // Demander l'heure
    TraiterErreur(send(sockfd,buffer,sizeof(buffer),0));
    printf("Demande l'heure en cour ...\n");
    
    // Recupèrer l'heure 
    
    TraiterErreur(recv(sockfd,&receive,sizeof(receive),0));
    printf("L'heure est : %s",receive);

    close(sockfd);
    return 0;
}
