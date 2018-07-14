package a.bakewithfun1;

import android.content.Intent;
import android.widget.RemoteViewsService;
import android.widget.RemoteViewsService.RemoteViewsFactory;
import com.android.tools.ir.runtime.IncrementalChange;
import com.android.tools.ir.runtime.InstantReloadException;

public class WidgetService
  extends RemoteViewsService
{
  public static final long serialVersionUID = -3772229770687664302L;
  
  public WidgetService() {}
  
  WidgetService(Object[] paramArrayOfObject, InstantReloadException paramInstantReloadException)
  {
    this();
  }
  
  public RemoteViewsService.RemoteViewsFactory onGetViewFactory(Intent paramIntent)
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null) {
      return (RemoteViewsService.RemoteViewsFactory)localIncrementalChange.access$dispatch("onGetViewFactory.(Landroid/content/Intent;)Landroid/widget/RemoteViewsService$RemoteViewsFactory;", new Object[] { this, paramIntent });
    }
    return new IngredientViewsFactory(getApplicationContext(), paramIntent);
  }
}


/* Location:              D:\Programs\dex-tools\dex2jar-2.0\split_lib_slice_8_apk-dex2jar.jar!\a\bakewithfun1\WidgetService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */