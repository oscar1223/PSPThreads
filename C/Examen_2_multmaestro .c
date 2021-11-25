#include <stdio.h>
#include <stdlib.h>
#include <pvm3.h>

int main()
{
	int tareas, i;
	int etienvio1 = 1, etienvio2 = 2, etirecib = 3;
	int array1[10];
	int array2[10];
	int result1[5];
	int result2[5];
	int tid[2];

	printf("Proceso maestro : t%x\n", pvm_mytid());

	//SE RELLENAN LOS DOS ARRAYS
	for (i=0; i<10; i++) {
		array1[i] = i;
		array2[i] = i;
	}
	
	//SE LANZAN LAS TAREAS
	tareas = pvm_spawn("multesclavo", (char **) 0, 0, "", 2, tid);
	printf("Tareas : %d\n", tareas); //Mostramos el número de tareas lanzadas (2)
	
	//SE ENVÍA EL PRIMER ARRAY A LOS DOS ESCLAVOS
	for (i=0; i<2; i++) {
		pvm_initsend(PvmDataDefault);
		pvm_pkint(array1 + i*5, 5, 1);
		pvm_send(tid[i], etienvio1);
		printf("array1 enviado a tarea %x\n", tid[i]);
	}
	
	//SE ENVÍA EL SEGUNDO ARRAY A LOS DOS ESCLAVOS
	for (i=0; i<2; i++) {
		pvm_initsend(PvmDataDefault);
		pvm_pkint(array2 + i*5, 5, 1);
		pvm_send(tid[i], etienvio2);
		printf("array2 enviado a tarea %x\n", tid[i]);
	}
	
	//SE RECIBE EL ARRAY DE LAS PRIMERAS 5 POSICIONES CON LAS MULTIPLICACIONES HECHAS
	pvm_recv(tid[0], etirecib);
	pvm_upkint(result1, 5, 1);
	
	//SE RECIBE EL ARRAY DE LAS ÚLTIMAS 5 POSICIONES CON LAS MULTIPLICACIONES HECHAS
	pvm_recv(tid[1], etirecib);
	pvm_upkint(result2, 5, 1);
	
	printf("El array devuelto con las multiplicaciones de las primeras cinco posiciones contiene:\n");
	for (i=0; i<5; i++) {
		printf("Posición %d: %d\n", i, result1[i]);
	}

	printf("El array devuelto con las multiplicaciones de las últimas cinco posiciones contiene:\n");
	for (i=0; i<5; i++) {
		printf("Posición %d: %d\n", i, result2[i]);
	}

	pvm_exit();
	exit (0);
}