package br.com.ibiraweb;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PageLoadListener// implements PhaseListener 
{

	  protected final static Log logger = LogFactory.getLog(PageLoadListener.class);

	  
	  
	  
	  // foi implementado mas nao esta sendo usado
//	  public void afterPhase(PhaseEvent phaseEvent) {
//	    FacesContext facesContext = phaseEvent.getFacesContext();
//	    String viewId = phaseEvent.getFacesContext().getViewRoot().getViewId();
//	    System.out.println(viewId);
//
//	    if (viewId.endsWith(".jsf")) {
//	      String managedBeanName = getManagedBeanNameFromView(viewId);
//	      Object object = facesContext.getApplication().createValueBinding("#{" + managedBeanName + "}").getValue(facesContext);
//	      if (object == null)
//	        logger.error("OnPageLoad cannot be executed, no such managed bean:"+ managedBeanName);
//	      else {
//	        ILifeCycleAware lifeCycleAwareBean = (ILifeCycleAware) object;
//	        lifeCycleAwareBean.onPageLoad();
//	      }
//	    }
//	    
//	    
	    
	    
	    
//	      // fix for renderer kit (Mojarra's and PrimeFaces's ajax redirect)
//        if ((RequestContext.getCurrentInstance().isAjaxRequest() || fc.getPartialViewContext().isPartialRequest()) && fc.getResponseWriter() == null && fc.getRenderKit() == null) {
//            ServletResponse response = (ServletResponse) ec.getResponse();
//            ServletRequest request = (ServletRequest) ec.getRequest();
//            response.setCharacterEncoding(request.getCharacterEncoding());
//
//            RenderKitFactory factory = (RenderKitFactory) FactoryFinder.getFactory(FactoryFinder.RENDER_KIT_FACTORY);
//            RenderKit renderKit = factory.getRenderKit(fc, fc.getApplication().getViewHandler().calculateRenderKitId(fc));
//
//            ResponseWriter responseWriter = renderKit.createResponseWriter(response.getWriter(), null, request.getCharacterEncoding());
//            fc.setResponseWriter(responseWriter);
//        }
//        HttpSession session = (HttpSession) ec.getSession(true);
//        /* Aqui recuperamos o usuário autenticado setado no MB autenticacaoController */
//        Usuario usuario = (Usuario) session.getAttribute("usuarioAutenticado");
//
//        // Quando o usuário informar na URL manualmente a página de exibição de perfis ou usuários, o qual permite remover um usuário ou perfil existente no sistema, verificamos se o ID do perfil deste usuário autenticado é Administrador, caso não seja, redirecionamos o mesmo para a página principal, não permitindo acesso à tal página. Este modelo pode ser implementado para qualquer outra página a qual não deseje que o usuário tenha acesso. 
//        if ((usuario != null && !usuario.getPerfil().getIdPerfil().equals(Constantes.ID_PERFIL_ADMINISTRADOR)) && (fc.getViewRoot().getViewId().contains(Constantes.PAGINA_EXIBIR_PERFIL) || fc.getViewRoot().getViewId().contains(Constantes.PAGINA_EXIBIR_USUARIO))) {
//            ec.redirect(ec.getRequestContextPath() + "/app" + Constantes.PAGINA_INDEX);
//        }
//    } catch (IOException e) {
//        System.out.println("Redirect to the specified login page " + Constantes.PAGINA_INDEX + " failed");
//        throw new FacesException(e);
//    }
//	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
//	    
//	  }

//	  public void beforePhase(PhaseEvent phaseEvent) {
//	    
//	  }
//
//	  public PhaseId getPhaseId() {
//	    return PhaseId.RESTORE_VIEW;
//	  }
//
//	  public String getManagedBeanNameFromView(String viewId) {
//	    String pageName = viewId.substring(1, viewId.length() - 4);
//	    return "pc_" + org.apache.commons.lang.StringUtils.capitalise(pageName);
//	  }

	}      