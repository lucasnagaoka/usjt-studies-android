package br.usjt.deswebmob.aula3_navigation.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import br.usjt.deswebmob.aula3_navigation.R;
import br.usjt.deswebmob.aula3_navigation.model.entity.Pais;

/**
 * @author Lucas Nagaoka | RA: 81513916
 * CCP3AN-MCA2
 */

public class PaisAdapter<T> extends BaseAdapter {
    private Pais[] paises;
    private Activity activity;

    public PaisAdapter(Pais[] paises, Activity activity) {
        this.paises = paises;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return this.paises.length;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View view = convertView;

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater)
                    activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.linha_pais, viewGroup, false);
            ImageView bandeira = (ImageView) view.findViewById(R.id.foto_pais);
            TextView nome = (TextView) view.findViewById(R.id.texto_nome_pais);
            TextView detalhe = (TextView) view.findViewById(R.id.texto_detalhe_pais);
            ViewHolder viewHolder = new ViewHolder(bandeira, nome, detalhe);
            view.setTag(viewHolder);
        }

        ViewHolder viewHolder = (ViewHolder) view.getTag();
        viewHolder.getNome().setText(paises[i].getNome());
        viewHolder.getDetalhe().setText(String.format(
                activity.getResources().getString(R.string.lbl_regiao)+
                        " %s - "+
                        activity.getResources().getString(R.string.lbl_capital)+
                        " %s",
                paises[i].getRegiao(),
                paises[i].getCapital()));
        Drawable drawable = Util.getDrawable(activity, paises[i].getCodigo3().toLowerCase());
        if (drawable == null) {
            drawable = activity.getDrawable(R.drawable.bandeira);
        }
        System.out.println(paises[i].getNome());
        viewHolder.getBandeira().setImageDrawable(drawable);

        return view;
    }

    @Override
    public Object getItem(int position) {
        return paises[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder {
        ImageView bandeiraImageView;
        TextView nomeTextView, detalheTextView;

        public ViewHolder(ImageView iconeImageView, TextView... textViews) {
            this.bandeiraImageView = iconeImageView;
            this.nomeTextView = textViews[0];
            this.detalheTextView = textViews[1];
        }

        public ImageView getBandeira() {
            return bandeiraImageView;
        }

        public void setBandeira(ImageView bandeira) {
            this.bandeiraImageView = bandeira;
        }

        public TextView getNome() {
            return nomeTextView;
        }

        public void setNome(TextView nome) {
            this.nomeTextView = nome;
        }

        public TextView getDetalhe() {
            return detalheTextView;
        }

        public void setDetalhe(TextView detalhe) {
            this.detalheTextView = detalhe;
        }
    }
}
