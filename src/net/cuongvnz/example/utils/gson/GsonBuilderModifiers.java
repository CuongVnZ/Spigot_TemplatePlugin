/*
 *	  ___  _   _                     ____________ _____
 *	 / _ \| | | |                    | ___ \ ___ \  __ \
 *	/ /_\ \ |_| |__   ___ _ __   __ _| |_/ / |_/ / |  \/
 *	|  _  | __| '_ \ / _ \ '_ \ / _` |    /|  __/| | __
 *	| | | | |_| | | |  __/ | | | (_| | |\ \| |   | |_\ \
 *	\_| |_/\__|_| |_|\___|_| |_|\__,_\_| \_\_|    \____/
 *
 */
package net.cuongvnz.example.utils.gson;

import com.google.gson.GsonBuilder;

@FunctionalInterface
public interface GsonBuilderModifiers {
    public GsonBuilder modify(GsonBuilder builder);
}