package nl.topicusonderwijs.custom.errorpage.quickstart;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class HomePage extends WebPage
{
	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters)
	{
		super(parameters);

		add(new Link<>("trigger")
		{
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick()
			{
				throw new IllegalStateException("This is not a legal state");
			}
		});
	}
}
