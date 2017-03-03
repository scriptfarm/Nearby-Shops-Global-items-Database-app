package nbsidb.nearbyshops.org.RetrofitRESTContract;

import javax.annotation.security.RolesAllowed;

import nbsidb.nearbyshops.org.Model.Image;
import nbsidb.nearbyshops.org.ModelItemSpecification.EndPoints.ItemSpecNameEndPoint;
import nbsidb.nearbyshops.org.ModelItemSpecification.ItemSpecificationName;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by sumeet on 3/3/17.
 */

public interface ItemSpecService {


    @POST ("/api/v1/ItemSpecificationName")
    Call<ItemSpecificationName> saveItemSpecName(@Header("Authorization") String headers,
                                                @Body ItemSpecificationName itemSpecName);




    @PUT("/api/v1/ItemSpecificationName/{ImageID}")
    Call<ResponseBody> updateItemSpec(@Header("Authorization") String headers,
                                      @Body ItemSpecificationName itemSpecName,
                                      @Path("ImageID")int imageID);




    @DELETE ("/api/v1/ItemSpecificationName/{ItemSpecNameID}")
    Call<ResponseBody> deleteItemSpecName(@Header("Authorization") String headers,
                                          @Path("ItemSpecNameID")int itemSpecNameID);




    @GET ("/api/v1/ItemSpecificationName/OuterJoin")
    Call<ItemSpecNameEndPoint> getItemSpecName(
            @Query("ItemCatID")Integer itemCatID,
            @Query("SortBy") String sortBy,
            @Query("Limit")Integer limit, @Query("Offset")Integer offset,
            @Query("GetRowCount")Boolean getRowCount);





    // Image Calls

    @POST("/api/v1/ItemSpecificationName/Image")
    Call<Image> uploadItemImage(@Header("Authorization") String headers,
                                @Body RequestBody image);


    @DELETE("/api/v1/ItemSpecificationName/Image/{name}")
    Call<ResponseBody> deleteItemImage(@Header("Authorization") String headers,
                                       @Path("name") String fileName);



}