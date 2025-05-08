package Model;

public class Tupla<C,V> {
	
	private C c;
	private V v;
	
	public Tupla(C clave, V valor) {
		this.c = clave;
		this.v = valor;
	}

	public C getC() {
		return c;
	}

	public void setC(C c) {
		this.c = c;
	}

	public V getV() {
		return v;
	}

	public void setV(V v) {
		this.v = v;
	}

	@Override
	public String toString() {
		return " [" + c + " = " + v + "]";
	}
	
}