package entidades;

public class Avaliacao {
	
		private Usuario avaliador;
	    private Usuario avaliado;
	    private int nota;
	    private String comentario;

	    public Avaliacao(Usuario avaliador, Usuario avaliado, int nota, String comentario) {
	        this.avaliador = avaliador;
	        this.avaliado = avaliado;
	        this.nota = nota;
	        this.comentario = comentario;
	    }

	    public int getNota() {
	        return nota;
	    }

	    public String getComentario() {
	        return comentario;
	    }

	    public Usuario getAvaliador() {
	        return avaliador;
	    }

	    public Usuario getAvaliado() {
	        return avaliado;
	        
	    }

	
}
