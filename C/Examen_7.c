#include <stdio.h>
#include <signal.h>
#include <stdlib.h>
#include <fcntl.h>

void gestion_padre( int segnal )
{
printf("Soy el hijo con pid %d\n", getpid());
}

void gestion_hijo( int segnal )
{
printf("Soy el padre con pid %d\n", getpid());
}

int main()
{
	int pid_padre, pid_hijo;
	pid_padre = getpid();
	pid_hijo = fork(); //creamos hijo
	
		switch(pid_hijo)
		{
			case -1:
			printf( "Error al crear el proceso hijo...\n");
			exit( -1 );
			case 0: //HIJO
			signal( SIGUSR2, gestion_hijo );
			while(1) {
			sleep(1);
			printf("Hijo envía señal..\n");
			kill(pid_padre, SIGUSR1);//ENVIA SEÑAL AL PADRE
			pause();
			kill(pid_padre, SIGKILL); //HACE QUE EL PROCESO PADRE TERMINE
			}
			break;
			default: //PADRE

			signal( SIGUSR1, gestion_padre );
			while(1) {
			pause();
			sleep(1);
			printf("Padre envía señal..\n");
			kill(pid_hijo, SIGUSR2);//ENVIA SEÑAL AL HIJO
			}
			break;
		}
		
	return 0;
}