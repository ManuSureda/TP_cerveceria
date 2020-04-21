# TP_cerveceria

1) Eso depende, de la forma en la que lo hice con tan solo un consumidor el stock puede llegar a 0.
lo arme de dos formas primero con un for de 0 a 100, ahi podia quedar en 0 o no (independientemente del numero de consumidores)
en el ultimo commit comente el for y use un while, ahora siempre termina en 0, ya que por como lo arme el productor deja de producir cuando alcanza su tope, y el consumidor seguira consumiendo hasta acavar con el stock.

2) los bloques deben ser Synchronized ya que estan accediendo a la "seccion critica" es decir que acceden a un recurso compartido (la cerveza), de esta forma evitamos que accedan al mismo tiempo al mismo dato.

3) es una estructura de datos o dispositivos al que mas de 1 hilo quiere acceder.

4) 1. crear una clase que extienda de la clase Thread y llamando a su constructor:
      ClaseQueExtiendeThread obj = new ClaseQueExtiendeThread();
      obj.start();

   2. crear una clase que implemente la interfaz "Runnable", y luego crear un Thread que reciva como parametro esta nueva clase
      ClaseImpRunnable obj = new ClaseImpRunnable();
      Thread t = new Thread(obj);
      t.start();
      
   3. Utilizar la clase Thread:
      Thread t = new Thread();
      t.start();
