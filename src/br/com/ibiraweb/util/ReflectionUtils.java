package br.com.ibiraweb.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.cfg.beanvalidation.IntegrationException;

import br.com.ibiraweb.iqualitywebws.FaultBean;
import br.com.ibiraweb.iqualitywebws.InvalidInputException;


/**
 * The Class ReflectionUtils.
 */
public class ReflectionUtils {

	/**
	 * Execute retorna o method.
	 *
	 * @param f o f
	 * @param requestBean o request bean
	 * @return o object
	 * @throws InvalidInputException 
	 */
	public static Object executeGetMethod(Field f, Object requestBean) throws InvalidInputException {
        try {
            Method getMethod = requestBean.getClass().getMethod("get" + StringUtils.capitalize(f.getName()));
            return getMethod.invoke(requestBean);
        } catch (NoSuchMethodException ex) {
            throw new InvalidInputException("O campo " + f.getName() + " da classe " + requestBean.getClass().getName() + " não possui um metodo get",new FaultBean(), ex);
        } catch (Exception ex) {
            throw new InvalidInputException("Houve um erro ao tentar acessar o metodo get do campo "
            		+ f.getName() + " da classe " + requestBean.getClass().getName(),new FaultBean(), ex);
        }
    }
	
	public static Object executeGetMethod(String f, Object requestBean) throws InvalidInputException {
        try {
            Method getMethod = requestBean.getClass().getMethod("get" + StringUtils.capitalize(f));
            return getMethod.invoke(requestBean);
        } catch (NoSuchMethodException ex) {
            throw new InvalidInputException("O campo " + f + " da classe " + requestBean.getClass().getName() + " não possui um metodo get",new FaultBean(), ex);
        } catch (Exception ex) {
            throw new InvalidInputException("Houve um erro ao tentar acessar o metodo get do campo "
            		+ f + " da classe " + requestBean.getClass().getName(),new FaultBean(), ex);
        }
    }

	/**
	 * Busca e executa o método setter para os parâmetros especificados.
	 * Caso exista um setter específico para o grupo de parâmetros, o mesmo será invocado, do contrário, será buscado
	 * um método que atenda qualquer uma das interfaces ou superclasse do parâmetro valueType.
	 * @param field nome do campo relacionado ao setter
	 * @param responseObject objeto no qual o setter será invocado
	 * @param value o valor a ser atribuído no setter
	 * @param valueType o tipo de parâmetro do setter
	 * @throws InvalidInputException 
	 */
	 public static void executeSet(Field field, Object responseObject, Object value, Class<?> valueType) throws InvalidInputException {
		 	
		 	String prefixoMetodo = "";
		 	if (field.getType().isAssignableFrom(List.class)) {
				prefixoMetodo = "add";
			} else {
				prefixoMetodo = "set";
			}
     	
	        try {
	        	Method[] methods = responseObject.getClass().getMethods();
	        		        	
	        	for (Method method : methods) {
	        		if (method.getName().equals(prefixoMetodo + StringUtils.capitalize(field.getName()))) {
	    				
	    				Class<?>[] parameterTypes = method.getParameterTypes();
	    				
	    				for (Class<?> class1 : parameterTypes) {
	    					
	    					if (class1.equals(valueType)) {
	    						method.invoke(responseObject, value);
								return;
	    					} else if (class1.equals(valueType.getSuperclass())) {
								method.invoke(responseObject, value);
								return;
	    					} else {
	    						
	    						Class<?>[] interfaces = valueType.getInterfaces();
	
	    						for (Class<?> class3 : interfaces) {
	    							if (class3.equals(class1)) {
	    	    						method.invoke(responseObject, value);
	    	    						return;
	    	    					}
								}
	    						
	    					}
	    				}
	    			}
				}

	            throw new InvalidInputException("O campo " + field.getName() + " da classe " 
	            		+ responseObject.getClass().getName() + " não possui um " + prefixoMetodo,new FaultBean());
	        } catch (Exception ex) {
	            throw new InvalidInputException("Houve um erro ao tentar acessar o metodo " + prefixoMetodo + " do campo "
	            		+ field.getName() + " da classe " + responseObject.getClass().getName(),new FaultBean(), ex);
	        }
	    }


    /**
     * Execute set.
     *
     * @param field o field
     * @param responseObject o response object
     * @param value o value
     * @throws InvalidInputException 
     */
    public static void executeSet(Field field, Object responseObject, Object value) throws InvalidInputException {
    	executeSet(field, responseObject, value, value.getClass());
    }

	/**
	 * Retorna a todos os métodos declarados da classe
	 * e das superclasses até AbstractRequest.
	 *
	 * @param classRequest Classe do request.
	 * @return Lista de métodos.
	 */
	public static List<Method> getAllMethods(Class<?> classRequest) {
		List<Method> methods = new ArrayList<Method>();
		getAllMethods(methods, classRequest);

		return methods;
	}

	/**
	 * Método recursivo auxiliar para getAllFields(Class<?>).
	 *
	 * @param methods Lista de métodos.
	 * @param classRequest Classe do request.
	 * @return Lista de métodos.
	 */
	public static List<Method> getAllMethods(List<Method> methods, Class<?> classRequest) {
		methods.addAll(Arrays.asList(classRequest.getDeclaredMethods()));

	    if (classRequest.getSuperclass() != null) {
	    	methods = getAllMethods(methods, classRequest.getSuperclass());
	    }

	    return methods;
	}

}
