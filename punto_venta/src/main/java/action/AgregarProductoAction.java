package action;

import com.opensymphony.xwork2.ActionSupport;

import dao.ProductoDAO;
import pojo.Productos;

public class AgregarProductoAction extends ActionSupport{

	private static final long serialVersionUID = -3827439829486925185L;
	private Productos productos;

	@Override
	public String execute() throws Exception {
		System.out.println("Clave del Producto Saved: " + productos.getClave());
		System.out.println("Descripcion Saved: " + productos.getDescripcion());
		System.out.println("Unidad de Venta Saved: " + productos.getUnidad());
		System.out.println("Invenatario Saved: " + productos.getInventario());
		System.out.println("Precio de Venta Saved: " + productos.getPrecio());
		return "REGISTER";
	}

	public Productos getProductos() {
		return productos;
	}

	public void setProductos(Productos productos) {
		this.productos = productos;
	}
	
	public String agregarProducto()
	{
		//ProductoDAO daoproducto = new ProductoDAO();
		try
		{
			ProductoDAO.insertProducto(productos.getClave(), productos.getDescripcion(), productos.getUnidad(), productos.getInventario(), productos.getPrecio());
			return SUCCESS;
		}catch (Exception e)
		{
			e.printStackTrace();
			//mensajeError = "Error al crear producto";
			return ERROR;
		}
	}

	
	
}