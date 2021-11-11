package nl.topicusonderwijs.custom.errorpage.quickstart;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public class CustomErrorPage extends WebPage
{
	private static final long serialVersionUID = 1L;

	public CustomErrorPage()
	{
		init(null);
	}

	public CustomErrorPage(Exception e)
	{
		init(e);
	}

	private void init(Exception e)
	{
		IModel<Exception> exceptionModel = Model.of(e);

		add(new Label("exceptionClass",
			exceptionModel.map(Exception::getClass).map(Class::getName).orElse("unknown")));
		add(new Label("exceptionMessage", exceptionModel.map(Exception::getMessage).orElse("-")));
	}
}
