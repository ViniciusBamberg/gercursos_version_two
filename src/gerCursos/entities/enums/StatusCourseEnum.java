package gerCursos.entities.enums;

public enum StatusCourseEnum {

	INSCRIÇÕES,
	EM_ANDAMENTO,
	CONCLUÍDO;

	public static StatusCourseEnum getStatus(StatusCourseEnum status) {
			return status;
	}
}
