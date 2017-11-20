package cn.hdu.exception;

/**
 * 
 * @author 王冶
 * 自定义异常，用于持久层异常处理
 *
 */
public class CustomException extends Exception {

	private static final long serialVersionUID = 1L;
		private String message;

		public CustomException(String message) {
			super();
			this.message = message;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
	
}
