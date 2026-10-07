public class ObjVisitante {
    private int Turno;
    private String Nombre;
    private String Documento;
    private int Funcionario;
    private int Estado;

    public int getTurno() {
        return Turno;
    }

    public void setTurno(int turno) {
        Turno = turno;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getDocumento() {
        return Integer.parseInt(Documento);
    }

    public void setDocumento(int documento) {
    Documento = Integer.toString(documento);
    }

    public int getFuncionario() {
        return Funcionario;
    }

    public void setFuncionario(int funcionario) {
        Funcionario = funcionario;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int estado) {
        Estado = estado;
    }
}