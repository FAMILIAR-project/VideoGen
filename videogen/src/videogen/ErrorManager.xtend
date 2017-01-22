package videogen

class ErrorManager {
	
	private final val OK=0
	private final val WARNING=1
	private final val ERROR=2
	
	var code = OK
	
	def warning(String message){
		System.err.println("WARNING : "+message)
		if(code < WARNING){
			code = WARNING
		}
	}
	
	def error(String message){
		System.err.println("ERROR : "+message)
		if(code < ERROR){
			code = ERROR
		}
	}
	
	def getCode(){
		code
	}
}