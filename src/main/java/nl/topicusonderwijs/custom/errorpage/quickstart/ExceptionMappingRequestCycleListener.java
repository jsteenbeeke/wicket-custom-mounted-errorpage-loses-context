package nl.topicusonderwijs.custom.errorpage.quickstart;

import org.apache.wicket.core.request.handler.PageProvider;
import org.apache.wicket.core.request.handler.RenderPageRequestHandler;
import org.apache.wicket.protocol.http.PageExpiredException;
import org.apache.wicket.request.IRequestHandler;
import org.apache.wicket.request.cycle.IRequestCycleListener;
import org.apache.wicket.request.cycle.RequestCycle;

public class ExceptionMappingRequestCycleListener
		implements org.apache.wicket.request.cycle.IRequestCycleListener
{
	@Override
	public IRequestHandler onException(RequestCycle cycle, Exception ex)
	{
		if (!(ex instanceof PageExpiredException))
		{
			return new RenderPageRequestHandler(new PageProvider(new CustomErrorPage(ex)),
				RenderPageRequestHandler.RedirectPolicy.ALWAYS_REDIRECT);
		}

		return IRequestCycleListener.super.onException(cycle, ex);
	}
}
