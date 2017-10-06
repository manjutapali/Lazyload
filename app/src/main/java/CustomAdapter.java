import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.manjunathtapali.lazyloadimages.PriorityQueue.ImageMetaNode;
import com.manjunathtapali.lazyloadimages.R;

import java.util.List;

/**
 * Created by tapalim on 10/6/17.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ImageViewHolder>{

    private LayoutInflater layoutInflater;
    private List<ImageMetaNode> images;
    private Context context;

    public CustomAdapter(Context context, List<ImageMetaNode> images)
    {
        this.context = context;
        this.images = images;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.list_images, parent, false);
        ImageViewHolder viewHolder = new ImageViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if(images != null)
            return images.size();

        return 0;
    }

    class ImageViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        public ImageViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.img);
        }
    }
}
