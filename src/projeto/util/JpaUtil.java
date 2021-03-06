package projeto.util;

import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

public class JpaUtil {

	private static final String ENTITY_MANAGER = "ENTITY_MANAGER";
	private static EntityManagerFactory entityManagerFactory;

	public static void iniciarPersistenceUnit() {
		if (entityManagerFactory == null)
			entityManagerFactory = Persistence
					.createEntityManagerFactory("control_exped_pu");
	}
	
	public static EntityManager createEntityManager() {
		return entityManagerFactory.createEntityManager();
	}

	public static void fecharPersistenceUnit() {
		entityManagerFactory.close();		
	}
	
	public static EntityManager getEntityManager() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		EntityManager entityManager = (EntityManager) request.getAttribute(ENTITY_MANAGER);
		return entityManager;
	}

	public static void setEntityManager(ServletRequest request,
			EntityManager entityManager) {
		request.setAttribute(ENTITY_MANAGER, entityManager);
		
	}
}