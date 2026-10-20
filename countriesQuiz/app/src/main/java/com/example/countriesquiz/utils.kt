package com.example.countriesquiz
import android.content.Context

class Constants{
    companion object{
        const val KEY1 = "NAIROBI"
        const val KEY2 = "KUALA LUMPUR"
        const val KEY3 = "GUADALAJARA"
    }
}
class Countries{
    companion object{
        fun loadDrawableIds(context: Context): IntArray {
            val typedArray = context.resources.obtainTypedArray(R.array.country_array)
            val drawableIds = IntArray(typedArray.length()) { i ->
                typedArray.getResourceId(i, 0)
            }
            typedArray.recycle()
            return drawableIds
        }
    }
}

