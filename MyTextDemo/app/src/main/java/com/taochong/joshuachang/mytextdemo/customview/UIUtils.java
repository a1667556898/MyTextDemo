package com.taochong.joshuachang.mytextdemo.customview;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.os.Build;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SearchView;

import java.lang.reflect.Field;

/**
 * Created by jiangzhenwei on 16/6/6.
 */
public class UIUtils {

    public static final int ACTIONBAR_HEIGHT = android.R.attr.actionBarSize;
    private static Context context = null;
    private static DisplayMetrics dm = null;
    private static boolean followSystemBackground = true;

    public static DisplayMetrics getDM() {
        return dm;
    }

    public static float getDensity() {
        return dm.density;
    }

    public static void initDisplayMetrics(Context ctx, WindowManager wm, boolean isFollowSystemBackground) {
        if (context == null) {
            context = ctx;
        }

        dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        followSystemBackground = isFollowSystemBackground;

    }

    public static boolean touchInDialog(Activity activity, MotionEvent e) {
        int leftW, rightW, topH, bottomH;
        leftW = 8;
        rightW = dm.widthPixels - leftW;
        topH = 0;
        bottomH = 450;
        return ((e.getX() > leftW) && (e.getX() < rightW) && (e.getY() > topH) && (e.getY() < bottomH));
    }

    public static boolean isScreenCenter(MotionEvent e) {
        boolean ret = true;
        if (e.getX() < (dm.widthPixels / 2 - 25)) {
            ret = false;
        }
        if (e.getX() > (dm.widthPixels / 2 + 25)) {
            ret = false;
        }
        if (e.getY() < (dm.heightPixels / 2 - 25)) {
            ret = false;
        }
        if (e.getY() > (dm.heightPixels / 2 + 25)) {
            ret = false;
        }
        return ret;
    }

    public static PointF getLeftBottomPoint() {
        return new PointF((dm.widthPixels / 4) + 0.09f, (dm.heightPixels / 4 * 3) + 0.09f);
    }

    public static PointF getRightBottomPoint() {
        return new PointF((dm.widthPixels / 4 * 3) + 0.09f, (dm.heightPixels / 4 * 3) + 0.09f);
    }

    public static PointF getLeftPoint() {
        return new PointF(20, dm.heightPixels / 2);
    }

    public static PointF getRightPoint() {
        return new PointF(dm.widthPixels - 20, dm.heightPixels / 2);
    }

    public static boolean isTouchLeft(MotionEvent e) {
        return (e.getX() < (dm.widthPixels / 2));
    }

    public static void setActivitySizePos(Activity activity, int x, int y, int width, int height) {
        WindowManager.LayoutParams p = activity.getWindow().getAttributes();
        p.x = x;
        p.y = y;
        p.width = width;
        p.height = height;
        activity.getWindow().setAttributes(p);
    }

    public static int dipToPx(int dip) {
        if (dm == null) {
            return -1;
        }
        return (int) (dip * dm.density + 0.5f);
    }

    public static float dipToPx(float dip) {
        if (dm == null) {
            return -1;
        }
        return (dip * dm.density + 0.5f);
    }

    public static float pxToScaledPx(int px) {
        if (dm == null) {
            return -1;
        }
        return px / dm.density;
    }

    public static int scaledPxToPx(float scaledPx) {
        if (dm == null) {
            return -1;
        }
        return (int) (scaledPx * dm.density);
    }

    public static int countViewAdvWidth(int count, int innerMargin, int outerMargin) {
        int width = dm.widthPixels - (outerMargin * 2);
        width = width - (innerMargin * (count - 1));
        width = width / count;
        return width;
    }

    public static int countViewAdvWidthByFrame(int count, int innerMargin, int outerMargin, int frameWidth) {
        int width = frameWidth - (outerMargin * 2);
        width = width - (innerMargin * (count - 1));
        width = width / count;
        return width;
    }

    public static int countViewAdvHeight(int count, int innerMargin, int outerMargin) {
        int height = dm.heightPixels - (outerMargin * 2);
        height = height - (innerMargin * (count - 1));
        height = height / count;
        return height;
    }

    public static int countViewAdvHeightByFrame(int count, int innerMargin, int outerMargin, int frameHeight) {
        int height = frameHeight - (outerMargin * 2);
        height = height - (innerMargin * (count - 1));
        height = height / count;
        return height;
    }

    public static int getWidth() {
        return dm.widthPixels;
    }

    public static int getHeight() {
        return dm.heightPixels;
    }

    public static void setActivitySizeX(Activity a, int size) {
        WindowManager.LayoutParams lp = a.getWindow().getAttributes();
        lp.width = size;
        a.getWindow().setAttributes(lp);
    }

    public static void setActivitySizeY(Activity a, int size) {
        WindowManager.LayoutParams lp = a.getWindow().getAttributes();
        lp.height = size;
        a.getWindow().setAttributes(lp);
    }

    public static void setActivityPercentX(Activity a, float percent) {
        WindowManager.LayoutParams lp = a.getWindow().getAttributes();
        lp.width = (int) (getWidth() * percent / 100);
        a.getWindow().setAttributes(lp);
    }

    public static void setActivityPercentY(Activity a, float percent) {
        WindowManager.LayoutParams lp = a.getWindow().getAttributes();
        lp.height = (int) (getHeight() * percent / 100);
        a.getWindow().setAttributes(lp);
    }

    public static void setViewSizeX(View v, int size) {
        ViewGroup.LayoutParams lp = v.getLayoutParams();
        lp.width = size;
        v.setLayoutParams(lp);
    }

    public static void setViewSizeY(View v, int size) {
        ViewGroup.LayoutParams lp = v.getLayoutParams();
        lp.height = size;
        v.setLayoutParams(lp);
    }

    public static void setViewPercentX(View v, float percent) {
        ViewGroup.LayoutParams lp = v.getLayoutParams();
        lp.width = (int) (getWidth() * percent / 100);
        v.setLayoutParams(lp);
    }

    public static void setViewPercentY(View v, float percent) {
        ViewGroup.LayoutParams lp = v.getLayoutParams();
        lp.height = (int) (getHeight() * percent / 100);
        v.setLayoutParams(lp);
    }

    public static void setViewPercentXByFrame(View v, float percent, float frameXPercent) {
        ViewGroup.LayoutParams lp = v.getLayoutParams();
        lp.width = (int) ((getWidth() * frameXPercent / 100) * percent / 100);
        v.setLayoutParams(lp);
    }

    public static void setViewPercentYByFrame(View v, float percent, float frameYPercent) {
        ViewGroup.LayoutParams lp = v.getLayoutParams();
        lp.height = (int) ((getHeight() * frameYPercent / 100) * percent / 100);
        v.setLayoutParams(lp);
    }

    public static void setViewPaddingPercent(View v, float paddingLeft, float paddingTop, float paddingRight, float paddingBottom) {
        int pLeft = (int) (getWidth() * paddingLeft / 100);
        int pTop = (int) (getHeight() * paddingTop / 100);
        int pRight = (int) (getWidth() * paddingRight / 100);
        int pBottom = (int) (getHeight() * paddingBottom / 100);
        v.setPadding(pLeft, pTop, pRight, pBottom);
    }

    public static void makeListViewFullSize(ListView lv, int itemHeight) {
        int itemCount = lv.getAdapter().getCount();
        int divider = lv.getDividerHeight();
        int height = (itemHeight + divider) * itemCount;
        ViewGroup.LayoutParams lp = lv.getLayoutParams();
        lp.height = height;
        lv.setLayoutParams(lp);
    }

    public static void makeGridViewFullSize(GridView gv, int itemHeight, int rowNum) {
        int itemCount = gv.getAdapter().getCount();
        int lines = (int) (itemCount / rowNum);
        if (itemCount % rowNum != 0) {
            lines++;
        }
        ViewGroup.LayoutParams lp = gv.getLayoutParams();
        lp.height = lines * itemHeight;
        gv.setLayoutParams(lp);

    }

    public static int getActionBarHeight() {
        TypedArray a = context.obtainStyledAttributes(new int[]{ACTIONBAR_HEIGHT});
        int ret = a.getDimensionPixelSize(0, -1);
        a.recycle();
        return ret;
    }

    public static boolean isFollowSystemBackground() {
        return followSystemBackground;
    }

    public static void setFollowSystemBackground(boolean isFollowSystemBackground) {
        followSystemBackground = isFollowSystemBackground;
    }

    public static int getStatusBarHeight() {
        int resId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int height = context.getResources().getDimensionPixelSize(resId);
        return height;
    }

    public static int getNavigationBarHeight() {
        if (hasNavigationBar()) {
            int resId = context.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
            int height = context.getResources().getDimensionPixelSize(resId);
            return height;
        }
        return 0;
    }

    public static boolean hasNavigationBar() {
        boolean hasMenuKey = ViewConfiguration.get(context).hasPermanentMenuKey();
        boolean hasBackKey = KeyCharacterMap.deviceHasKey(KeyEvent.KEYCODE_BACK);
        return (!hasMenuKey && !hasBackKey);
    }

    public static void setImmersion(Activity activity, boolean immersion) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (immersion) {
                activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                if (hasNavigationBar()) {
                    activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
                }
            }else{
                activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                if (hasNavigationBar()) {
                    activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
                }
            }
        }
    }
    /** 顶部状态栏和底部导航栏 是否已显示 */
    public static boolean isShowSystemUI(Context context){
        if(context instanceof Activity){
            int visibility = ((Activity) context).getWindow().getDecorView().getSystemUiVisibility();
            return visibility == View.VISIBLE;
        }
        return false;
    }

    /** 顶部状态栏和底部导航栏 显示
     * 说明:
     * 全屏显示和隐藏,需要页面初始化设置setImmersion
     * 1)UIUtils.setImmersion
     * 2)show or hide
     * */
    public static void showSystemUI(Context context){
        if(context instanceof Activity){
            ((Activity) context).getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_VISIBLE);
        }
    }

    /** 顶部状态栏和底部导航栏 隐藏 */
    public static void hideSystemUI(Context context){
        if(context instanceof Activity){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                ((Activity) context).getWindow().getDecorView().setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                                | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                                | View.SYSTEM_UI_FLAG_IMMERSIVE);
            }
        }
    }

    /** 横屏全部隐藏,竖屏只隐藏顶部状态栏 */
    public static void hideSystemUIByScreen(Context context){
        if(context instanceof Activity && Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            //隐藏导航栏
            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
            System.out.println("隐藏导航栏 1111111");
            if (context.getResources().getConfiguration().orientation
                    == Configuration.ORIENTATION_LANDSCAPE) {
                System.out.println("隐藏导航栏 222222222");
                //横屏设置状态栏和导航栏都隐藏
                uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                        | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                        | View.SYSTEM_UI_FLAG_IMMERSIVE;
            }
            ((Activity) context).getWindow().getDecorView().setSystemUiVisibility(uiOptions);
        }
    }

    public static void setFitSystem(Activity activity, int res, boolean immersion) {
        View v = activity.findViewById(res);
        if (v instanceof ViewGroup) {
            setFitSystem(activity, (ViewGroup) v, immersion);
        }
    }

    public static void setFitSystem(Activity activity, ViewGroup v, boolean immersion) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (immersion) {
                v.setFitsSystemWindows(true);
                v.setClipToPadding(true);
            }
        }
    }

//    public static void setStatusbarColor(boolean isBlack) {
//        if (context instanceof Activity) {
//            if (DeviceUtils.isMiuiV6()) {
//                Window w = ((Activity) context).getWindow();
//                Class<?> clz = w.getClass();
//                try {
//                    int darkFlag = 0;
//                    Class<?> layoutParam = Class.forName("android.view.MiuiWindowManager$LayoutParams");
//                    Field field = layoutParam.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");
//                    darkFlag = field.getInt(layoutParam);
//                    Method extraFlag = clz.getMethod("setExtraFlags", int.class, int.class);
//                    extraFlag.invoke(w, (isBlack ? darkFlag : 0), darkFlag);
//                } catch (Exception e) {
//
//                }
//            }
//        }
//    }

    public static void setSeachViewTextBackground(SearchView sv, int backgroundRes) {
        try {
            Class<?> clz = sv.getClass();
            Field fSearchPlate = clz.getDeclaredField("mSearchPlate");
            fSearchPlate.setAccessible(true);
            View vSearchPlate = (View) fSearchPlate.get(sv);
            vSearchPlate.setBackgroundResource(backgroundRes);

            Field fSubmitArea = clz.getDeclaredField("submit_area");
            fSubmitArea.setAccessible(true);
            View vSubmitArea = (View) fSubmitArea.get(sv);
            vSubmitArea.setBackgroundResource(backgroundRes);

        } catch (Exception e) {

        }

    }

    /**
     * 侵入式
     *
     * @param view 控制器主布局
     */
    public static void setImmerseLayout(Activity act, View view, boolean isPadd) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = act.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            if (isPadd) {
                int statusBarHeight = UIUtils.getStatusBarHeight();
                view.setPadding(0, statusBarHeight, 0, 0);
            }
        }
    }

    /**
     * 获取字体的宽度
     * @param text
     * @param textSize
     * @return
     */
    public static float getTextWidth(String text, int textSize){
        TextPaint paint = new TextPaint();
        float scaledDensity = context.getResources().getDisplayMetrics().scaledDensity;
        paint.setTextSize(scaledDensity * textSize);
        return paint.measureText(text);
    }

    /**
     * 阴影状态条是否显示
     * @return
     */
    public static boolean isStatusBarBgVisible() {
        return true;
    }
}
