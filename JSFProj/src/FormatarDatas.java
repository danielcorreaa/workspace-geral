import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatarDatas {
	
	private Date dataNascimento;

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getDataNascimentoFormat() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(dataNascimento);
	}

	public void setDataNascimento(String dataNascimento) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			this.dataNascimento = sdf.parse(dataNascimento);
		} catch (ParseException e) {
			this.dataNascimento = new Date();
		}
	}
	
	public static void main(String[] args) {
		FormatarDatas df = new FormatarDatas();
		
		df.setDataNascimento("17/11/2015");
		
		System.out.println(df.getDataNascimentoFormat());
	}
	
	

}
