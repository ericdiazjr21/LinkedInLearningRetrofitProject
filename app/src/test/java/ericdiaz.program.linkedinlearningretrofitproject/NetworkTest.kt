package ericdiaz.program.linkedinlearningretrofitproject

import ericdiaz.program.linkedinlearningretrofitproject.api.GithubService
import ericdiaz.program.linkedinlearningretrofitproject.api.RetrofitSingleton
import ericdiaz.program.linkedinlearningretrofitproject.model.Gist
import org.junit.Assert
import org.junit.Test
import retrofit2.Response

class NetworkTest {

    private val service: GithubService = RetrofitSingleton.gitHubService

    @Test
    fun testGetPublicGistsFor200CodeWhenSynchronouslyCalled() {
        //given
        val expectedCode = 200

        //when
        val response: Response<List<Gist>> = service.getPublicGists().execute()

        //then
        Assert.assertNotNull(response.body())
        Assert.assertEquals(expectedCode, response.code())
    }

    @Test
    fun testGetStarredGistsFor200CodeWhenSynchronouslyCalled() {
        //given
        val expectedCode = 401 // because login is required

        //when
        val response: Response<List<Gist>> = service.getStarredGists().execute()

        //then
//        Assert.assertNotNull(response.body())
        Assert.assertEquals(expectedCode, response.code())
    }

    @Test
    fun testGetUserGistsFor200CodeWhenSynchronouslyCalled() {
        //given
        val expectedCode = 200

        //when
        val response: Response<List<Gist>> = service.getUserGists().execute()

        //then
        Assert.assertNotNull(response.body())
        Assert.assertEquals(expectedCode, response.code())
    }
}