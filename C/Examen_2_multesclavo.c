#include <stdio.h>
#include <stdlib.h>
#include <pvm3.h>

int main()
{
	int etienvio = 3, etirecib1 = 1, etirecib2 = 2;
	int array1[5];
	int array2[5];
	int result[5];
	int i, mytid, parent_tid;

	mytid = pvm_mytid();
	parent_tid = pvm_parent();

	//RECIBE EL PRIMER ARRAY DEL MAESTRO
	pvm_recv(parent_tid, etirecib1);
	pvm_upkint(array1, 5, 1);

	//RECIBE EL SEGUNDO ARRAY DEL MAESTRO
	pvm_recv(parent_tid, etirecib2);
	pvm_upkint(array2, 5, 1);

	for (i=0; i<5; i++) {
		result[i] = array1[i] * array2[i];
	}

	//ENVÍA AL PADRE EL ARRAY CON LAS MULTIPLICACIONES HECHAS
	pvm_initsend(PvmDataDefault);
	pvm_pkint(result + 0*5, 5, 1);
	pvm_send(parent_tid, etienvio);

	pvm_exit();
	exit (0);
}
