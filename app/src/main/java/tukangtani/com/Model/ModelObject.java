package tukangtani.com.Model;


import tukangtani.com.R;

/* NIM   : 10116107
*  Nama  : Ady Aprilriyan Rizki
*  Kelas : AKB-3 / IF3
*  Tanggla Pengerjaan : 09/08/2019*/

public enum ModelObject {

    slide1(R.string.s1, R.layout.slide1),
    slide2(R.string.s2, R.layout.slide2),
    slide3(R.string.s3, R.layout.slide3);


    private int mTitleResId;
        private int mLayoutResId;

        ModelObject(int titleResId, int layoutResId) {
            mTitleResId = titleResId;
            mLayoutResId = layoutResId;
        }

        public int getTitleResId() {
            return mTitleResId;
        }

        public int getLayoutResId() {
            return mLayoutResId;
        }



}
