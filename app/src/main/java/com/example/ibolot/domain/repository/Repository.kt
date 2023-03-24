package com.example.ibolot.domain.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.classwork5.utils.Constant
import com.example.ibolot.BuildConfig
import com.example.ibolot.domain.ApiService
import com.example.ibolot.domain.RetrofitClient
import com.example.ibolot.domain.model.ServiceItem
import com.example.ibolot.domain.result.Resource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {
    private val apiService: ApiService by lazy {
        RetrofitClient.create()
    }

    fun getPlaylists(): LiveData<Resource<ServiceItem>> {
        val data = MutableLiveData<Resource<ServiceItem>>()

        data.value = Resource.loading()
        apiService.getPlaylists(
            BuildConfig.API_KEY,
            Constant.part,
            Constant.channelId,
            Constant.maxResults
        )
            .enqueue(object : Callback<ServiceItem> {
                override fun onResponse(call: Call<ServiceItem>, response: Response<ServiceItem>) {
                    if (response.isSuccessful) {
                        data.value = Resource.success(response.body())
                    }
                }

                override fun onFailure(call: Call<ServiceItem>, t: Throwable) {
                    print(t.stackTrace)

                    data.value = Resource.error(t.stackTrace.toString(), null, null)
                }

            })
        return data
    }

    fun getItemList(id:String): LiveData<ServiceItem> {
        val data = MutableLiveData<ServiceItem>()
        apiService.getItemLists(
            BuildConfig.API_KEY, Constant.part, Constant.channelId, Constant.maxResults,id)
            .enqueue(object : Callback<ServiceItem> {
                override fun onResponse(call: Call<ServiceItem>, response: Response<ServiceItem>) {
                    if (response.isSuccessful) {
                        data.value = response.body()
                    }
                }

                override fun onFailure(call: Call<ServiceItem>, t: Throwable) {
                    print(t.stackTrace)
                }

            })
        return data
    }
}