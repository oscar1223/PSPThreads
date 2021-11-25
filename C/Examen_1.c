#include <stdlib.h>
#include <stdio.h>

int main () {
	
	int pid_hijo, pid_padre, pid_nieto, i;
	
	
	for (i=0; i<2; i++) {
		
		pid_hijo = fork();
		
		if (i == 0) {
			pid_hijo = getpid();
			
			switch (pid_hijo) {
				case -1:
					printf("Error al crear el proceso hijo1");
					exit(-1);
				case 0: //PROCESO HIJO

					pid_nieto = fork();
					pid_nieto = getpid();
					
					switch (pid_nieto) {
						case -1:
							printf("Error al crear el proceso hijo2");
							exit(-1);
						case 0: //PROCESO NIETO
							printf("Soy el proceso NIETO %d; Mi padre es = %d\n", pid_nieto, getppid());
							break;
						default: //PROCESO HIJO
							printf("Soy el proceso HIJO %d; Mi padre es = %d\n", pid_hijo, getppid());
							printf("Mi hijo: %d terminó\n", pid_nieto);
							break;
						}

					break;
				default: //PROCESO PADRE
					break;
		
			}
		}
		
		if (i == 1) {
			
			pid_hijo = getpid();
			
			switch (pid_hijo) {
				case -1:
					printf("Error al crear el proceso hijo2");
					exit(-1);
				case 0: //PROCESO HIJO2
					printf("Soy el proceso HIJO2 %d; Mi padre es = %d\n", pid_hijo, getppid());
					break;
				default: //PROCESO PADRE
					printf("Soy el proceso ABUELO: %d; Mi HIJO: nosé terminó, mi HIJO: %d terminó\n", getpid(), pid_hijo);
					break;
			}
			
		}
		
	}
	
	/*for (i=0; i<2; i++) {
		wait(NULL);
	}*/
	
	
	return 0;
}