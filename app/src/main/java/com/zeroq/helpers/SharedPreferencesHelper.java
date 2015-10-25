package com.zeroq.helpers;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;
import java.util.Set;

/**
 * Created by user-1 on 25/10/15.
 */
public class SharedPreferencesHelper {

    private SharedPreferences.Editor editor;
    private SharedPreferences prefs;
    String prefFile;

    public SharedPreferencesHelper(String prefFile) {
        this.prefFile = prefFile;
    }

    public Map<String, ?> getAll(Activity context){
        prefs = context.getSharedPreferences(prefFile, 0);
        return prefs.getAll();
    }

    public Boolean getBoolean(Activity context, String key, Boolean defaultValue){
        prefs = context.getSharedPreferences(prefFile, 0);
        return prefs.getBoolean(key, defaultValue);
    }

    public float getFloat(Activity context, String key, float defaultValue){
        prefs = context.getSharedPreferences(prefFile, 0);
        return prefs.getFloat(key, defaultValue);
    }

    public int getInt(Activity context, String key, int defaultValue){
        prefs = context.getSharedPreferences(prefFile, 0);
        return prefs.getInt(key, defaultValue);
    }

    public long getLong(Activity context, String key, long defaultValue){
        prefs = context.getSharedPreferences(prefFile, 0);
        return prefs.getLong(key, defaultValue);
    }

    public String getString(Activity context, String key, String defaultValue){
        prefs = context.getSharedPreferences(prefFile, 0);
        return prefs.getString(key, defaultValue);
    }

    public Set<String> getStringSet(Activity context, String key, Set<String> defaultValue){
        prefs = context.getSharedPreferences(prefFile, 0);
        return prefs.getStringSet(key, defaultValue);
    }

    public Boolean contains(Activity context, String key) {
        prefs = context.getSharedPreferences(prefFile, 0);
        return prefs.contains(key);
    }

    public void registerOnChangeListener(Activity context, SharedPreferences.OnSharedPreferenceChangeListener listener) {
        prefs = context.getSharedPreferences(prefFile, 0);
        prefs.registerOnSharedPreferenceChangeListener(listener);
    }

    public void unregisterOnChangeListener(Activity context, SharedPreferences.OnSharedPreferenceChangeListener listener) {
        prefs = context.getSharedPreferences(prefFile, 0);
        prefs.unregisterOnSharedPreferenceChangeListener(listener);
    }

    public void putBoolean(Activity context, String key, Boolean value) {
        prefs = context.getSharedPreferences(prefFile, 0);
        editor = prefs.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public void putFloat(Activity context, String key, float value) {
        prefs = context.getSharedPreferences(prefFile, 0);
        editor = prefs.edit();
        editor.putFloat(key, value);
        editor.apply();
    }

    public void putInt(Activity context, String key, int value) {
        prefs = context.getSharedPreferences(prefFile, 0);
        editor = prefs.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public void putLong(Activity context, String key, long value) {
        prefs = context.getSharedPreferences(prefFile, 0);
        editor = prefs.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    public void putString(Activity context, String key, String value) {
        prefs = context.getSharedPreferences(prefFile, 0);
        editor = prefs.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public void putStringSet(Activity context, String key, Set<String> value) {
        prefs = context.getSharedPreferences(prefFile, 0);
        editor = prefs.edit();
        editor.putStringSet(key, value);
        editor.apply();
    }

    public void remove(Activity context, String key) {
        prefs = context.getSharedPreferences(prefFile, 0);
        editor = prefs.edit();
        editor.remove(key);
        editor.apply();
    }

    public void clear(Activity context) {
        prefs = context.getSharedPreferences(prefFile, 0);
        editor = prefs.edit();
        editor.clear();
        editor.apply();
    }

    public Map<String, ?> getAll(Service context){
        prefs = context.getSharedPreferences(prefFile, 0);
        return prefs.getAll();
    }

    public Boolean getBoolean(Service context, String key, Boolean defaultValue){
        prefs = context.getSharedPreferences(prefFile, 0);
        return prefs.getBoolean(key, defaultValue);
    }

    public float getFloat(Service context, String key, float defaultValue){
        prefs = context.getSharedPreferences(prefFile, 0);
        return prefs.getFloat(key, defaultValue);
    }

    public int getInt(Service context, String key, int defaultValue){
        prefs = context.getSharedPreferences(prefFile, 0);
        return prefs.getInt(key, defaultValue);
    }

    public long getLong(Service context, String key, long defaultValue){
        prefs = context.getSharedPreferences(prefFile, 0);
        return prefs.getLong(key, defaultValue);
    }

    public String getString(Service context, String key, String defaultValue){
        prefs = context.getSharedPreferences(prefFile, 0);
        return prefs.getString(key, defaultValue);
    }

    public Set<String> getStringSet(Service context, String key, Set<String> defaultValue){
        prefs = context.getSharedPreferences(prefFile, 0);
        return prefs.getStringSet(key, defaultValue);
    }

    public Boolean contains(Service context, String key) {
        prefs = context.getSharedPreferences(prefFile, 0);
        return prefs.contains(key);
    }

    public void registerOnChangeListener(Service context, SharedPreferences.OnSharedPreferenceChangeListener listener) {
        prefs = context.getSharedPreferences(prefFile, 0);
        prefs.registerOnSharedPreferenceChangeListener(listener);
    }

    public void unregisterOnChangeListener(Service context, SharedPreferences.OnSharedPreferenceChangeListener listener) {
        prefs = context.getSharedPreferences(prefFile, 0);
        prefs.unregisterOnSharedPreferenceChangeListener(listener);
    }

    public void putBoolean(Service context, String key, Boolean value) {
        prefs = context.getSharedPreferences(prefFile, 0);
        editor = prefs.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public void putFloat(Service context, String key, float value) {
        prefs = context.getSharedPreferences(prefFile, 0);
        editor = prefs.edit();
        editor.putFloat(key, value);
        editor.apply();
    }

    public void putInt(Service context, String key, int value) {
        prefs = context.getSharedPreferences(prefFile, 0);
        editor = prefs.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public void putLong(Service context, String key, long value) {
        prefs = context.getSharedPreferences(prefFile, 0);
        editor = prefs.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    public void putString(Service context, String key, String value) {
        prefs = context.getSharedPreferences(prefFile, 0);
        editor = prefs.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public void putStringSet(Service context, String key, Set<String> value) {
        prefs = context.getSharedPreferences(prefFile, 0);
        editor = prefs.edit();
        editor.putStringSet(key, value);
        editor.apply();
    }

    public void remove(Service context, String key) {
        prefs = context.getSharedPreferences(prefFile, 0);
        editor = prefs.edit();
        editor.remove(key);
        editor.apply();
    }

    public void clear(Service context) {
        prefs = context.getSharedPreferences(prefFile, 0);
        editor = prefs.edit();
        editor.clear();
        editor.apply();
    }

    public Map<String, ?> getAll(Context context){
        prefs = getPrefs(context);
        return prefs.getAll();
    }

    public Boolean getBoolean(Context context, String key, Boolean defaultValue){
        prefs = getPrefs(context);
        return prefs.getBoolean(key, defaultValue);
    }

    public float getFloat(Context context, String key, float defaultValue){
        prefs = getPrefs(context);
        return prefs.getFloat(key, defaultValue);
    }

    public int getInt(Context context, String key, int defaultValue){
        prefs = getPrefs(context);
        return prefs.getInt(key, defaultValue);
    }

    public long getLong(Context context, String key, long defaultValue){
        prefs = getPrefs(context);
        return prefs.getLong(key, defaultValue);
    }

    public String getString(Context context, String key, String defaultValue){
        prefs = getPrefs(context);
        return prefs.getString(key, defaultValue);
    }

    public Set<String> getStringSet(Context context, String key, Set<String> defaultValue){
        prefs = getPrefs(context);
        return prefs.getStringSet(key, defaultValue);
    }

    public Boolean contains(Context context, String key) {
        prefs = getPrefs(context);
        return prefs.contains(key);
    }

    public void registerOnChangeListener(Context context, SharedPreferences.OnSharedPreferenceChangeListener listener) {
        prefs = getPrefs(context);
        prefs.registerOnSharedPreferenceChangeListener(listener);
    }

    public void unregisterOnChangeListener(Context context, SharedPreferences.OnSharedPreferenceChangeListener listener) {
        prefs = getPrefs(context);
        prefs.unregisterOnSharedPreferenceChangeListener(listener);
    }

    public void putBoolean(Context context, String key, Boolean value) {
        prefs = getPrefs(context);
        editor = prefs.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public void putFloat(Context context, String key, float value) {
        prefs = getPrefs(context);
        editor = prefs.edit();
        editor.putFloat(key, value);
        editor.apply();
    }

    public void putInt(Context context, String key, int value) {
        prefs = getPrefs(context);
        editor = prefs.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public void putLong(Context context, String key, long value) {
        prefs = getPrefs(context);
        editor = prefs.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    public void putString(Context context, String key, String value) {
        prefs = getPrefs(context);
        editor = prefs.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public void putStringSet(Context context, String key, Set<String> value) {
        prefs = getPrefs(context);
        editor = prefs.edit();
        editor.putStringSet(key, value);
        editor.apply();
    }

    public void remove(Context context, String key) {
        prefs = getPrefs(context);
        editor = prefs.edit();
        editor.remove(key);
        editor.apply();
    }

    public void clear(Context context) {
        prefs = getPrefs(context);
        editor = prefs.edit();
        editor.clear();
        editor.apply();
    }

    private SharedPreferences getPrefs(Context context) {
        if(context instanceof Activity) {
            return ((Activity) context).getSharedPreferences(prefFile, 0);
        }
        else {
            return ((Service) context).getSharedPreferences(prefFile, 0);
        }
    }
}


