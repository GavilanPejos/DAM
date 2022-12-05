package com.example.rolife.fragments;

public interface interfaceFragments {
    void changeFragment(String procedencia);//Para cambiar Fragmento
    /* switch (procedencia) {
            case "register":
                fragment = new loginACTRegister_Fragment();
                break;
            case "forget":
                fragment = new loginACTForget_Fragment();
                break;
            case "login":
                fragment = new loginACTLogin_Fragment();
                break;
        }
        //fragment = new loginACTRegister_Fragment();
        fragmentManager = getSupportFragmentManager();//lo convertimos en un support de verdad
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.add(R.id.loginActivity_FLcontainerfragments, fragment);
        fragmentTransaction.commit();//Acción de realizar.*/
    void removeFragment();//Para quitar fragmento
        /*        getActivity().getFragmentManager().beginTransaction().remove(this).commit();*/
    }

