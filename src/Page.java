public class Page {

    public String name="Page";
    public int numPage;
    String data="Some data";

    public Page( int numPage){

        this.numPage=numPage;
    }

    public int getNumPage(){
        return numPage;

    }
    @Override
    public String toString(){

        return this.name+" "+ this.numPage + " " + this.data;
    }
}
