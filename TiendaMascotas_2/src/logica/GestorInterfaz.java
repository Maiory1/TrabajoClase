package logica;

import java.util.List;

public interface GestorInterfaz <T> {
	
	public List<T> obtenerTodos();
	
	public List<T> obtenerPorId(int id);
	
	public T addPet();
	
	public T eliminatePet();
	
	public T modifyPet();
	
	
}
