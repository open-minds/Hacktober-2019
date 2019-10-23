#define SOCK_ERROR -1
#define INVALID_SOCKET -1

#include<sys/types.h>
#include<stdio.h>
#include<sys/socket.h>
#include<sys/types.h>
#include<netinet/in.h>
#include<arpa/inet.h>
#include<string.h>

int main(int argc, char const *argv[])
{
    int sock;
    struct sockaddr_in servSocket;
    char buffer[1024]="";
    int socketConn;
    sock = socket(AF_INET,SOCK_STREAM,0);

     if(sock != INVALID_SOCKET){
         
         servSocket.sin_family = AF_INET;
         servSocket.sin_addr.s_addr = inet_addr("127.0.0.1");
         servSocket.sin_port = htons(1300);
         
         bzero(&servSocket.sin_zero,8);
         printf("Structure complet \n");
         
         
         socketConn = connect(sock,(struct sockaddr *)&servSocket,sizeof(servSocket));
        // printf("%d",socketConn);
         
         
         if ( socketConn != SOCK_ERROR){
         
             printf("Conexion établie \n");
         
             if(recv(sock,buffer,sizeof(buffer),0) != SOCK_ERROR){
         
                 printf("J'ai reçu le message suivant %s",buffer);
         
             }else{
                 
                 perror("Echec de recv");
             } 
         
           printf("Terminer");
         
         }else{
             perror("Echec de connect");
         }
     }else{
         perror("Echec de socket");
     }
    return 0;
}
