
package model;


public class Matricula {
    private int codigo;
    private Aluno aluno;
    private Cursos curso;
    private Bolsas bolsa;
    private double valor_desc;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Cursos getCurso() {
        return curso;
    }

    public void setCurso(Cursos curso) {
        this.curso = curso;
    }

    public Bolsas getBolsa() {
        return bolsa;
    }

    public void setBolsa(Bolsas bolsa) {
        this.bolsa = bolsa;
    }

    public double getValor_desc() {
        return valor_desc;
    }

    public void setValor_desc(double valor_desc) {
        this.valor_desc = valor_desc;
    }
    
    
    

}
