package com.fabianbleile.bakeryapp.Fragment;

import com.fabianbleile.bakeryapp.utils.NetworkUtils;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.MediaSessionCompat.Callback;
import android.support.v4.media.session.PlaybackStateCompat.Builder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.android.tools.ir.runtime.IncrementalChange;
import com.android.tools.ir.runtime.InstantReloadException;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayer.EventListener;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

public class StepFragment
  extends Fragment
  implements ExoPlayer.EventListener
{
  private static final String TAG = StepFragment.class.getSimpleName();
  public static final long serialVersionUID = -5747682316334811106L;
  public OnImageClickListener mCallback;
  private String mDescription;
  public SimpleExoPlayer mExoPlayer;
  private String mId;
  private MediaSessionCompat mMediaSession;
  public ImageView mNoVideoAvailable;
  private String mShortDescription;
  public SimpleExoPlayerView mSimpleExoPlayerView;
  private PlaybackStateCompat.Builder mStateBuilder;
  private int mStepCount;
  private Uri mediaUri;
  private int recipeId;
  public Context thisContext;
  private String thumbnailUrl;
  private String videoUrl;
  
  public StepFragment() {}
  
  StepFragment(Object[] paramArrayOfObject, InstantReloadException paramInstantReloadException) {}
  
  private void initializeMediaSession()
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null)
    {
      localIncrementalChange.access$dispatch("initializeMediaSession.()V", new Object[] { this });
      return;
    }
    this.mMediaSession = new MediaSessionCompat(this.thisContext, TAG);
    this.mMediaSession.setFlags(3);
    this.mMediaSession.setMediaButtonReceiver(null);
    this.mStateBuilder = new PlaybackStateCompat.Builder().setActions(534L);
    this.mMediaSession.setPlaybackState(this.mStateBuilder.build());
    this.mMediaSession.setCallback(new mySessionCallback(null));
    this.mMediaSession.setActive(true);
  }
  
  private void initializePlayer(Uri paramUri)
  {
    Object localObject = $change;
    if (localObject != null)
    {
      ((IncrementalChange)localObject).access$dispatch("initializePlayer.(Landroid/net/Uri;)V", new Object[] { this, paramUri });
      return;
    }
    if (this.mExoPlayer == null)
    {
      localObject = new DefaultTrackSelector();
      DefaultLoadControl localDefaultLoadControl = new DefaultLoadControl();
      this.mExoPlayer = ExoPlayerFactory.newSimpleInstance(this.thisContext, (TrackSelector)localObject, localDefaultLoadControl);
      this.mSimpleExoPlayerView.setPlayer(this.mExoPlayer);
      localObject = Util.getUserAgent(this.thisContext, "ClassicalMusicQuiz");
      paramUri = new ExtractorMediaSource(paramUri, new DefaultDataSourceFactory(this.thisContext, (String)localObject), new DefaultExtractorsFactory(), null, null);
      this.mExoPlayer.prepare(paramUri);
      this.mExoPlayer.setPlayWhenReady(true);
    }
  }
  
  private void releasePlayer()
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null)
    {
      localIncrementalChange.access$dispatch("releasePlayer.()V", new Object[] { this });
      return;
    }
    this.mExoPlayer.stop();
    this.mExoPlayer.release();
    this.mExoPlayer = null;
  }
  
  public void onAttach(Context paramContext)
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null)
    {
      localIncrementalChange.access$dispatch("onAttach.(Landroid/content/Context;)V", new Object[] { this, paramContext });
      return;
    }
    super.onAttach(paramContext);
    try
    {
      this.mCallback = ((OnImageClickListener)paramContext);
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext.toString());
      localStringBuilder.append(" must implement OnImageClickListener");
      throw new ClassCastException(localStringBuilder.toString());
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    Object localObject1 = $change;
    if (localObject1 != null) {
      return (View)((IncrementalChange)localObject1).access$dispatch("onCreateView.(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", new Object[] { this, paramLayoutInflater, paramViewGroup, paramBundle });
    }
    this.thisContext = paramViewGroup.getContext();
    paramLayoutInflater = paramLayoutInflater.inflate(2131296289, paramViewGroup, false);
    paramViewGroup = (TextView)paramLayoutInflater.findViewById(2131165333);
    Object localObject2 = (TextView)paramLayoutInflater.findViewById(2131165231);
    paramBundle = (ImageView)paramLayoutInflater.findViewById(2131165353);
    localObject1 = (ImageView)paramLayoutInflater.findViewById(2131165351);
    this.mSimpleExoPlayerView = ((SimpleExoPlayerView)paramLayoutInflater.findViewById(2131165236));
    this.mNoVideoAvailable = ((ImageView)paramLayoutInflater.findViewById(2131165346));
    this.mNoVideoAvailable.setImageResource(2131099760);
    if (Integer.parseInt(this.mId) != 0)
    {
      ((TextView)localObject2).setText(this.mDescription.substring(3, this.mDescription.length()));
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("STEP ");
      ((StringBuilder)localObject2).append(this.mId);
      paramViewGroup.setText(((StringBuilder)localObject2).toString());
    }
    else
    {
      ((TextView)localObject2).setText(this.mDescription);
      paramViewGroup.setText("INTRO");
    }
    ((ImageView)localObject1).setOnClickListener(new View.OnClickListener()
    {
      public static final long serialVersionUID = 8720785802712237854L;
      
      public void onClick(View paramAnonymousView)
      {
        IncrementalChange localIncrementalChange = $change;
        if (localIncrementalChange != null)
        {
          localIncrementalChange.access$dispatch("onClick.(Landroid/view/View;)V", new Object[] { this, paramAnonymousView });
          return;
        }
        if (Integer.parseInt(StepFragment.access$000(StepFragment.this)) < StepFragment.access$100(StepFragment.this) - 1)
        {
          int i = Integer.parseInt(StepFragment.access$000(StepFragment.this));
          StepFragment.this.mCallback.onNextSelected(i + 1);
          return;
        }
        Toast.makeText(StepFragment.this.getContext(), "Congrats! You just finished the Recipe", 0).show();
      }
    });
    paramBundle.setOnClickListener(new View.OnClickListener()
    {
      public static final long serialVersionUID = 5632660746142092552L;
      
      public void onClick(View paramAnonymousView)
      {
        IncrementalChange localIncrementalChange = $change;
        if (localIncrementalChange != null)
        {
          localIncrementalChange.access$dispatch("onClick.(Landroid/view/View;)V", new Object[] { this, paramAnonymousView });
          return;
        }
        if (Integer.parseInt(StepFragment.access$000(StepFragment.this)) > 0)
        {
          int i = Integer.parseInt(StepFragment.access$000(StepFragment.this));
          StepFragment.this.mCallback.onPreviousSelected(i - 1);
          return;
        }
        StepFragment.this.mCallback.onPreviousSelected(-1);
      }
    });
    if (!this.videoUrl.isEmpty())
    {
      this.mSimpleExoPlayerView.setVisibility(0);
      this.mNoVideoAvailable.setVisibility(4);
      setMediaUri();
      initializeMediaSession();
      initializePlayer(this.mediaUri);
      return paramLayoutInflater;
    }
    this.mSimpleExoPlayerView.setVisibility(4);
    this.mNoVideoAvailable.setVisibility(0);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null)
    {
      localIncrementalChange.access$dispatch("onDestroy.()V", new Object[] { this });
      return;
    }
    super.onDestroy();
    if (!this.videoUrl.isEmpty()) {
      releasePlayer();
    }
  }
  
  public void onLoadingChanged(boolean paramBoolean)
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null)
    {
      localIncrementalChange.access$dispatch("onLoadingChanged.(Z)V", new Object[] { this, new Boolean(paramBoolean) });
      return;
    }
  }
  
  public void onPlayerError(ExoPlaybackException paramExoPlaybackException)
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null)
    {
      localIncrementalChange.access$dispatch("onPlayerError.(Lcom/google/android/exoplayer2/ExoPlaybackException;)V", new Object[] { this, paramExoPlaybackException });
      return;
    }
  }
  
  public void onPlayerStateChanged(boolean paramBoolean, int paramInt)
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null)
    {
      localIncrementalChange.access$dispatch("onPlayerStateChanged.(ZI)V", new Object[] { this, new Boolean(paramBoolean), new Integer(paramInt) });
      return;
    }
    if ((paramInt == 3) && (paramBoolean))
    {
      this.mStateBuilder.setState(3, this.mExoPlayer.getCurrentPosition(), 1.0F);
      this.mMediaSession.setPlaybackState(this.mStateBuilder.build());
      Log.d(TAG, "onPlayerStateChanged: PLAYING");
      return;
    }
    if (paramInt == 3)
    {
      this.mStateBuilder.setState(2, this.mExoPlayer.getCurrentPosition(), 1.0F);
      this.mMediaSession.setPlaybackState(this.mStateBuilder.build());
      Log.d(TAG, "onPlayerStateChanged: PAUSED");
    }
  }
  
  public void onPositionDiscontinuity()
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null)
    {
      localIncrementalChange.access$dispatch("onPositionDiscontinuity.()V", new Object[] { this });
      return;
    }
  }
  
  public void onTimelineChanged(Timeline paramTimeline, Object paramObject)
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null)
    {
      localIncrementalChange.access$dispatch("onTimelineChanged.(Lcom/google/android/exoplayer2/Timeline;Ljava/lang/Object;)V", new Object[] { this, paramTimeline, paramObject });
      return;
    }
  }
  
  public void onTracksChanged(TrackGroupArray paramTrackGroupArray, TrackSelectionArray paramTrackSelectionArray)
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null)
    {
      localIncrementalChange.access$dispatch("onTracksChanged.(Lcom/google/android/exoplayer2/source/TrackGroupArray;Lcom/google/android/exoplayer2/trackselection/TrackSelectionArray;)V", new Object[] { this, paramTrackGroupArray, paramTrackSelectionArray });
      return;
    }
  }
  
  public void setMediaUri()
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null)
    {
      localIncrementalChange.access$dispatch("setMediaUri.()V", new Object[] { this });
      return;
    }
    this.mediaUri = NetworkUtils.buildVideoUri(this.videoUrl);
  }
  
  public void setThumbnailUrl(String paramString)
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null)
    {
      localIncrementalChange.access$dispatch("setThumbnailUrl.(Ljava/lang/String;)V", new Object[] { this, paramString });
      return;
    }
    this.thumbnailUrl = paramString;
  }
  
  public void setVideoUrl(String paramString)
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null)
    {
      localIncrementalChange.access$dispatch("setVideoUrl.(Ljava/lang/String;)V", new Object[] { this, paramString });
      return;
    }
    this.videoUrl = paramString;
  }
  
  public void setmDescription(String paramString)
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null)
    {
      localIncrementalChange.access$dispatch("setmDescription.(Ljava/lang/String;)V", new Object[] { this, paramString });
      return;
    }
    this.mDescription = paramString;
  }
  
  public void setmId(String paramString, int paramInt)
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null)
    {
      localIncrementalChange.access$dispatch("setmId.(Ljava/lang/String;I)V", new Object[] { this, paramString, new Integer(paramInt) });
      return;
    }
    this.recipeId = paramInt;
    if ((this.recipeId == 3) && (Integer.parseInt(paramString) > 7))
    {
      this.mId = String.valueOf(Integer.parseInt(paramString) - 1);
      return;
    }
    this.mId = paramString;
  }
  
  public void setmShortDescription(String paramString)
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null)
    {
      localIncrementalChange.access$dispatch("setmShortDescription.(Ljava/lang/String;)V", new Object[] { this, paramString });
      return;
    }
    this.mShortDescription = paramString;
  }
  
  public void setmStepCount(int paramInt)
  {
    IncrementalChange localIncrementalChange = $change;
    if (localIncrementalChange != null)
    {
      localIncrementalChange.access$dispatch("setmStepCount.(I)V", new Object[] { this, new Integer(paramInt) });
      return;
    }
    this.mStepCount = paramInt;
  }
  
  public static abstract interface OnImageClickListener
  {
    public abstract void onNextSelected(int paramInt);
    
    public abstract void onPreviousSelected(int paramInt);
  }
  
  public class mySessionCallback
    extends MediaSessionCompat.Callback
  {
    public static final long serialVersionUID = 4677389708737815674L;
    
    private mySessionCallback() {}
    
    mySessionCallback(InstantReloadException paramInstantReloadException)
    {
      this();
    }
    
    public void onPause()
    {
      IncrementalChange localIncrementalChange = $change;
      if (localIncrementalChange != null)
      {
        localIncrementalChange.access$dispatch("onPause.()V", new Object[] { this });
        return;
      }
      super.onPause();
    }
    
    public void onPlay()
    {
      IncrementalChange localIncrementalChange = $change;
      if (localIncrementalChange != null)
      {
        localIncrementalChange.access$dispatch("onPlay.()V", new Object[] { this });
        return;
      }
      super.onPlay();
    }
    
    public void onSkipToPrevious()
    {
      IncrementalChange localIncrementalChange = $change;
      if (localIncrementalChange != null)
      {
        localIncrementalChange.access$dispatch("onSkipToPrevious.()V", new Object[] { this });
        return;
      }
      super.onSkipToPrevious();
    }
  }
}


/* Location:              D:\Programs\dex-tools\dex2jar-2.0\split_lib_slice_4_apk-dex2jar.jar!\a\bakewithfun1\Fragment\StepFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */