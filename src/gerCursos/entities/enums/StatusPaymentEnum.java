package gerCursos.entities.enums;

public enum StatusPaymentEnum {

	NAO_PAGO(1),
	PAGO(2),
	CANCELADO(3),
	ATRASADO(4);
	
	private int status;
	
	private StatusPaymentEnum(int status) {
		this.status = status;
	}

	public int getStatus(int status) {
		return status;
	}
}
