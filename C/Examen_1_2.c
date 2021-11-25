#include <stdlib.h>
#include <stdio.h>

int main () {
	
	int pid_hijo, pid_padre, pid_nieto, i;
	
	
	for (i=0; i<2; i++) {
		
		pid_hijo = fork();
		pid_hijo = getpid();
		if (i == 0) {
			if (pid_hijo == -1) {
				printf("No se ha podido crear el proceso hijo");
				exit(-1);
			}
			if (pid_hijo == 0) {
				pid_nieto = fork();
				pid_nieto = getpid();
					if (pid_nieto == -1) {
						printf("No se ha podido crear el proceso nieto");
						exit(-1);
					}
					if (pid_nieto == 0) { //PROCESO NIETO
						printf("Soy el proceso NIETO %d; Mi padre es = %d\n", pid_nieto, getppid());
				} else { //PROCESO HIJO
					printf("Soy el proceso HIJO %d; Mi padre es = %d\n", pid_hijo, getppid());
					printf("Mi hijo: %d terminó\n", pid_nieto);
				}
			} else { //	PROCESO PADRE
				
			}
		}
		
		if (i==1) {
			pid_hijo = fork();
			pid_hijo = getpid();
			if (pid_hijo == -1) {
				printf("No se ha podido crear el proceso hijo2");
				exit(-1);
			}
			if (pid_hijo == 0) { //PROCESO HIJO2
					printf("Soy el proceso HIJO2 %d; Mi padre es = %d\n", getpid(), getppid());
			} else { //PROCESO PADRE
				printf("Soy el proceso ABUELO: %d; Mi HIJO: %d terminó\n", getppid(), getpid());
			}
			
			
		}
	}

	
	for (i=0; i<2; i++) {
		wait(NULL);
	}
	
	
	return 0;
}