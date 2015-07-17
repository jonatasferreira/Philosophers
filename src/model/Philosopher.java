package model;

public class Philosopher extends Thread{
	private long begin = 0;
	private StatePhilosopher statePhilos;
	private Philosopher LEFT;
	private Philosopher RIGHT;
	private boolean semaphore;
	private int key;
	private Frame f;
	
	public Philosopher(int key, Frame f){
		this.statePhilos = StatePhilosopher.THINKING;
		this.semaphore = true;
		this.key = key;
		this.f = f;

		System.out.println("Filosofo "+key+" pensando...");
		begin = System.currentTimeMillis();
	}
	
	public void run(){
		System.out.println("Filosofo "+key+"   left "+this.LEFT.key+" - right "+this.RIGHT.key+"...");
		while(true){
			this.think();		// is thinking
			this.take_forks();	// takes two forks or blocks
			this.eat();			// is eating
			this.put_forks();	// returns to the table both forks
		}
	}
	
	/** Returns the two forks at the table
	 * 
	 */
	private void put_forks(){
		this.mutex_lock();								// enters the critical region
		this.statePhilos = StatePhilosopher.THINKING;	// just eating
		
		f.setStatePhilosopher(key, statePhilos);
		
		f.textArea.setText(f.textArea.getText()+"\nFilosofo "+key+" pensando... ");
		System.out.println("Filosofo "+key+" pensando..."+"Tempo comendo "+(System.currentTimeMillis()-begin));
		begin = System.currentTimeMillis();
		this.test(LEFT);								// see if the left is waiting to eat
		this.test(RIGHT); 								// see if the right is waiting to eat
		this.mutex_unlock();							// out of the critical region
	}
	
	/** Grab two forks or blocks
	 * 
	 */
	private void take_forks(){
		this.mutex_lock();								// enters the critical region
		this.statePhilos = StatePhilosopher.HUNGRY;		// records that the philosopher is hungry
		
		f.setStatePhilosopher(key, statePhilos);

		f.textArea.setText(f.textArea.getText()+"\nFilosofo "+key+" Faminto...");
		System.out.println("Filosofo "+key+" Faminto... "+"Tempo pensando "+(System.currentTimeMillis()-begin));
		begin = System.currentTimeMillis();
		this.test(this);								// tries to pick up two forks
		this.mutex_unlock();							// out of the critical region
		this.semaphore_lock();							// blocks if the forks were not caught
	}
	
	/** Test if the forks are free
	 * @param p: thread philosopher
	 */
	private void test(Philosopher p){
		if((p.statePhilos == StatePhilosopher.HUNGRY) && 
				(p.LEFT.statePhilos != StatePhilosopher.EATING) &&
				(p.RIGHT.statePhilos != StatePhilosopher.EATING) ){
			p.statePhilos = StatePhilosopher.EATING;
			
			f.setStatePhilosopher(p.key, p.statePhilos);
			p.semaphore_unlock();

			f.textArea.setText(f.textArea.getText()+"\nFilosofo "+p.key+" Comendo...");
			System.out.println("Filosofo "+p.key+" Comendo... "+"Tempo faminto ou bloqueado "+(System.currentTimeMillis()-begin));
			begin = System.currentTimeMillis();
		}
	}
	
	/** In the blocks been thinking for a while
	 * 
	 */
	private void think(){
		try{
			Thread.sleep(Integer.parseInt(Frame.TempoPens.getText()));
		}catch(Exception e){}
	}
	
	/** In the state blocks eating for a while
	 * 
	 */
	private void eat(){
		try{
			Thread.sleep(Integer.parseInt(Frame.TempoComen.getText()));
		}catch(Exception e){} 
	}

	/** Mutual exclusion, attempt to access the critical region
	 * 
	 */
	private void mutex_lock(){
		if(Main.mutex){
			f.textArea.setText(f.textArea.getText()+"\nFilosofo "+key+" Bloqueado, alguem está na região critica...");			
			System.out.println("Filosofo "+key+" Bloqueado, Alguém está na região critica... "+"Tempo estado anterior "+(System.currentTimeMillis()-begin));
			begin = System.currentTimeMillis();
		}
		while(Main.mutex);
		Main.mutex = true;
	}
	
	/** Mutual exclusion, exit the critical region
	 * 
	 */
	private void mutex_unlock(){
		Main.mutex = false;
	}
	
	/** Locks, if you have not caught the forks
	 * 
	 */
	private void semaphore_lock(){
		if(this.semaphore){ 
			f.textArea.setText(f.textArea.getText()+"\nFilosofo "+key+" Bloqueado, colega do lado está comendo...");
			System.out.println("Filosofo "+key+" Bloqueado, Colega do lado está comendo... "+"Tempo estado anterior "+(System.currentTimeMillis()-begin));
			begin = System.currentTimeMillis();
		}
		while(this.semaphore);
	}
	
	/** Unlocking the forks are available
	 * 
	 */
	private void semaphore_unlock(){
		this.semaphore = false;
	}
	
	/** The philosopher of the Left Arrow
	 * @param left
	 */
	public void setLEFT(Philosopher left) {
		LEFT = left;
	}

	/** Sets the philosopher of the right
	 * @param right
	 */
	public void setRIGHT(Philosopher right) {
		RIGHT = right;
	}
}
