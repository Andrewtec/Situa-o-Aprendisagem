package projeto.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import projeto.dao.ClienteDao;
import projeto.entity.Cliente;


	@ManagedBean
	public class ClienteMb {
		
	private ClienteDao clienteDao;
		
		private List<Cliente> clientes;
		private Cliente cliente;


		public List<Cliente> getClientes() {
			if(clientes == null){
				clientes = clienteDao.ListarClientes();
			}
			return clientes;
		}

		public void setClientes(List<Cliente> clientes) {
			this.clientes = clientes;
		}

		public Cliente getCliente() {
			return cliente;
		}

		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}
		
	 //***************  ações *****************************
		
		@PostConstruct
		public void init(){
			clienteDao = new ClienteDao();
			cliente = new Cliente();
		}
		
	public String salvar(){
			clienteDao.atualizarCliente(getCliente());
			return "clientelista";
		}
		
		public String carregarEdicao(String id){
			cliente = clienteDao.buscarPorId(Long.parseLong(id));
			return "cliente";
		}
		
		public String excluir(String id){
			clienteDao.excluirRegistroDeClientePorId(Long.parseLong(id));
			clientes = null;
			return "";
		}
}
