/*		
 * Copyright 2010 The EGF Co,. Ltd. 
 * site: http://www.egfit.com
 * file: $Id: ServiceDefinition.java 283 2010-03-11 07:41:26Z jcai $
 * created at:2010-2-7
 */
package lichen.ws.model;

import java.util.List;

/**
 * 服务定义
 * @author <a href="mailto:jun.tsai@gmail.com">Jun Tsai</a>
 * @version $Revision: 283 $
 * @since 0.1
 */
public class ServiceDefinition {
	/**
	 * remote service method parameter definition
	 * @author <a href="mailto:jun.tsai@gmail.com">Jun Tsai</a>
	 * @version $Revision: 283 $
	 * @since 0.1
	 */
	public static class ParameterDefinition {
		private String desc;
		/**
		 * @return the desc
		 */
		public String getDesc() {
			return desc;
		}
		/**
		 * @param desc the desc to set
		 */
		public void setDesc(String desc) {
			this.desc = desc;
		}
		private String type;
		/**
		 * @return the type
		 */
		public String getType() {
			return type;
		}
		/**
		 * @param type the type to set
		 */
		public void setType(String type) {
			this.type = type;
		}
	}
	/**
	 * method definition
	 * @author <a href="mailto:jun.tsai@gmail.com">Jun Tsai</a>
	 * @version $Revision: 283 $
	 * @since 0.1
	 */
	public static class MethodDefinition {
		private String name;
		private String desc;
		private String returnDesc;
		/**
		 * @return the desc
		 */
		public String getDesc() {
			return desc;
		}
		/**
		 * @param desc the desc to set
		 */
		public void setDesc(String desc) {
			this.desc = desc;
		}
		/**
		 * @return the returnDesc
		 */
		public String getReturnDesc() {
			return returnDesc;
		}
		/**
		 * @param returnDesc the returnDesc to set
		 */
		public void setReturnDesc(String returnDesc) {
			this.returnDesc = returnDesc;
		}
		/**
		 * @return the returnType
		 */
		public String getReturnType() {
			return returnType;
		}
		/**
		 * @param returnType the returnType to set
		 */
		public void setReturnType(String returnType) {
			this.returnType = returnType;
		}
		/**
		 * @return the parameterDefinitions
		 */
		public List<ParameterDefinition> getParameterDefinitions() {
			return parameterDefinitions;
		}
		/**
		 * @param parameterDefinitions the parameterDefinitions to set
		 */
		public void setParameterDefinitions(
				List<ParameterDefinition> parameterDefinitions) {
			this.parameterDefinitions = parameterDefinitions;
		}
		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}
		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}
		private String returnType;
		private List<ParameterDefinition> parameterDefinitions;
	}
	private String name;
	private String id;
	private String containerServiceId;
	private Class<?> serviceInterface;
	/**
	 * @return the containerServiceId
	 */
	public String getContainerServiceId() {
		return containerServiceId;
	}
	/**
	 * @param containerServiceId the containerServiceId to set
	 */
	public void setContainerServiceId(String containerServiceId) {
		this.containerServiceId = containerServiceId;
	}
	/**
	 * @return the serviceInterface
	 */
	public Class<?> getServiceInterface() {
		return serviceInterface;
	}
	/**
	 * @param serviceInterface the serviceInterface to set
	 */
	public void setServiceInterface(Class<?> serviceInterface) {
		this.serviceInterface = serviceInterface;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the methodDefinitions
	 */
	public List<MethodDefinition> getMethodDefinitions() {
		return methodDefinitions;
	}
	/**
	 * @param methodDefinitions the methodDefinitions to set
	 */
	public void setMethodDefinitions(List<MethodDefinition> methodDefinitions) {
		this.methodDefinitions = methodDefinitions;
	}
	private String description;
	private List<MethodDefinition> methodDefinitions;
}
