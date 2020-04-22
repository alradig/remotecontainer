package LogisticCompany.gui;

import dtu.library.dto.MediumInfo;

public class MediumPrinter {
	
	private MediumInfo medium;

	public MediumPrinter(MediumInfo medium) {
		this.medium = medium;
	}

	public String printDetail() {
		StringBuffer b = new StringBuffer();
		b.append("<html>"+medium.getTypeName()+"<br>");
		b.append(String.format("<b>Title:</b>     %s<br>", medium.getTitle()));
		b.append(String.format("<b>Author:</b>    %s<br>", medium.getAuthor()));
		b.append(String.format("<b>Signature:</b> %s<br></html>", medium.getSignature()));
		return b.toString();
	}
	
	public String print() {
			return medium.getTitle() + " by "+medium.getAuthor();
	}

}
