package tcs.attendence_tcs;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Context c=this;
    SharedPreferences sharedPreferences;
    TextView header;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(android.content.Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(android.content.Intent.EXTRA_SUBJECT,"Subject test");
                i.putExtra(android.content.Intent.EXTRA_TEXT, "link here");
                startActivity(Intent.createChooser(i,"Share via"));
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        sharedPreferences=getSharedPreferences("DATABASE",MODE_PRIVATE);
        View hView =  navigationView.getHeaderView(0);
        String data_signin = sharedPreferences.getString("data_signin", "Sign In");
        //Toast.makeText(MainActivity.this, data_signin, Toast.LENGTH_LONG).show();
        header= (TextView) hView.findViewById(R.id.header_text);
        header.setText(data_signin);






















//first cardView
        final TextView txt1= (TextView) findViewById(R.id.textView_1a);
        assert txt1 != null;
        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater layoutInflaterAndroid = LayoutInflater.from(c);
                View mView = layoutInflaterAndroid.inflate(R.layout.dialog_entry, null);
                AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(c);
                alertDialogBuilderUserInput.setView(mView);

                final EditText user_Input = (EditText) mView.findViewById(R.id.userInputDialog);
                final AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();

                user_Input.requestFocus();
                final InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);

                Button btn= (Button) mView.findViewById(R.id.button3);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String data = user_Input.getText().toString();
                        if(!user_Input.getText().toString().isEmpty()) {
                            SharedPreferences.Editor se = sharedPreferences.edit();
                            se.putString("data_1", data);
                            se.commit();
                            String data_1 = sharedPreferences.getString("data_1", "yo");
                            Toast.makeText(MainActivity.this, data_1, Toast.LENGTH_LONG).show();
                            txt1.setText(data_1);
                            alertDialogAndroid.dismiss();
                            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                        }
                        else{
                            Toast.makeText(MainActivity.this, "EMPTY , Put amount again", Toast.LENGTH_LONG).show();
                        }
                    }
                });

                alertDialogAndroid.show();
                alertDialogAndroid.setCanceledOnTouchOutside(true);
            }
        });
        String data_1 = sharedPreferences.getString("data_1", "Year");
        txt1.setText(data_1);
//
        final TextView txt2= (TextView) findViewById(R.id.textView_1b);
        assert txt2 != null;
        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater layoutInflaterAndroid = LayoutInflater.from(c);
                View mView = layoutInflaterAndroid.inflate(R.layout.dialog_entry, null);
                AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(c);
                alertDialogBuilderUserInput.setView(mView);

                final EditText user_Input = (EditText) mView.findViewById(R.id.userInputDialog);
                final AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();

                user_Input.requestFocus();
                final InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);

                Button btn= (Button) mView.findViewById(R.id.button3);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String data = user_Input.getText().toString();
                        if(!user_Input.getText().toString().isEmpty()) {
                            SharedPreferences.Editor se = sharedPreferences.edit();
                            se.putString("data_2", data);
                            se.commit();
                            String data_1 = sharedPreferences.getString("data_2", "yo");
                            Toast.makeText(MainActivity.this, data_1, Toast.LENGTH_LONG).show();
                            txt2.setText(data_1);
                            alertDialogAndroid.dismiss();
                            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                        }
                        else{
                            Toast.makeText(MainActivity.this, "EMPTY , Put amount again", Toast.LENGTH_LONG).show();
                        }
                    }
                });

                alertDialogAndroid.show();
                alertDialogAndroid.setCanceledOnTouchOutside(true);
            }
        });
        String data_2 = sharedPreferences.getString("data_2", "Branch");
        txt2.setText(data_2);
        //
        final TextView txt3= (TextView) findViewById(R.id.textView_1c);
        assert txt3 != null;
        txt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater layoutInflaterAndroid = LayoutInflater.from(c);
                View mView = layoutInflaterAndroid.inflate(R.layout.dialog_entry, null);
                AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(c);
                alertDialogBuilderUserInput.setView(mView);

                final EditText user_Input = (EditText) mView.findViewById(R.id.userInputDialog);
                final AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();

                user_Input.requestFocus();
                final InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);

                Button btn= (Button) mView.findViewById(R.id.button3);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String data_3 = user_Input.getText().toString();
                        if(!user_Input.getText().toString().isEmpty()) {
                            SharedPreferences.Editor se = sharedPreferences.edit();
                            se.putString("data_3", data_3);
                            se.commit();
                            String data_1 = sharedPreferences.getString("data_3", "yo");
                            Toast.makeText(MainActivity.this, data_1, Toast.LENGTH_LONG).show();
                            txt3.setText(data_3);
                            alertDialogAndroid.dismiss();
                            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                        }
                        else{
                            Toast.makeText(MainActivity.this, "EMPTY , Put amount again", Toast.LENGTH_LONG).show();
                        }
                    }
                });

                alertDialogAndroid.show();
                alertDialogAndroid.setCanceledOnTouchOutside(true);
            }
        });
        String data_3 = sharedPreferences.getString("data_3", "Subject");
        txt3.setText(data_3);








































        //SecondCardView
        final TextView txt2_a= (TextView) findViewById(R.id.textView_2a);
        assert txt2_a != null;
        txt2_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater layoutInflaterAndroid = LayoutInflater.from(c);
                View mView = layoutInflaterAndroid.inflate(R.layout.dialog_entry, null);
                AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(c);
                alertDialogBuilderUserInput.setView(mView);

                final EditText user_Input = (EditText) mView.findViewById(R.id.userInputDialog);
                final AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();

                user_Input.requestFocus();
                final InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);

                Button btn= (Button) mView.findViewById(R.id.button3);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String data = user_Input.getText().toString();
                        if(!user_Input.getText().toString().isEmpty()) {
                            SharedPreferences.Editor se = sharedPreferences.edit();
                            se.putString("data2_a", data);
                            se.commit();
                            String data2_a = sharedPreferences.getString("data2_a", "yo");
                            Toast.makeText(MainActivity.this, data2_a, Toast.LENGTH_LONG).show();
                            txt2_a.setText(data2_a);
                            alertDialogAndroid.dismiss();
                            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                        }
                        else{
                            Toast.makeText(MainActivity.this, "EMPTY , Put amount again", Toast.LENGTH_LONG).show();
                        }
                    }
                });

                alertDialogAndroid.show();
                alertDialogAndroid.setCanceledOnTouchOutside(true);
            }
        });
        String data2_a = sharedPreferences.getString("data2_a", "Year");
        txt2_a.setText(data2_a);
//
        final TextView txt_2b= (TextView) findViewById(R.id.textView_2b);
        assert txt_2b != null;
        txt_2b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater layoutInflaterAndroid = LayoutInflater.from(c);
                View mView = layoutInflaterAndroid.inflate(R.layout.dialog_entry, null);
                AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(c);
                alertDialogBuilderUserInput.setView(mView);

                final EditText user_Input = (EditText) mView.findViewById(R.id.userInputDialog);
                final AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();

                user_Input.requestFocus();
                final InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);

                Button btn= (Button) mView.findViewById(R.id.button3);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String data = user_Input.getText().toString();
                        if(!user_Input.getText().toString().isEmpty()) {
                            SharedPreferences.Editor se = sharedPreferences.edit();
                            se.putString("data_2b", data);
                            se.commit();
                            String data_2b = sharedPreferences.getString("data_2b", "yo");
                            Toast.makeText(MainActivity.this, data_2b, Toast.LENGTH_LONG).show();
                            txt_2b.setText(data_2b);
                            alertDialogAndroid.dismiss();
                            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                        }
                        else{
                            Toast.makeText(MainActivity.this, "EMPTY , Put amount again", Toast.LENGTH_LONG).show();
                        }
                    }
                });

                alertDialogAndroid.show();
                alertDialogAndroid.setCanceledOnTouchOutside(true);
            }
        });
        String data_2b = sharedPreferences.getString("data_2b", "Branch");
        txt_2b.setText(data_2b);
//

        final TextView txt_2c= (TextView) findViewById(R.id.textView_2c);
        assert txt_2c != null;
        txt_2c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater layoutInflaterAndroid = LayoutInflater.from(c);
                View mView = layoutInflaterAndroid.inflate(R.layout.dialog_entry, null);
                AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(c);
                alertDialogBuilderUserInput.setView(mView);

                final EditText user_Input = (EditText) mView.findViewById(R.id.userInputDialog);
                final AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();

                user_Input.requestFocus();
                final InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);

                Button btn= (Button) mView.findViewById(R.id.button3);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String data = user_Input.getText().toString();
                        if(!user_Input.getText().toString().isEmpty()) {
                            SharedPreferences.Editor se = sharedPreferences.edit();
                            se.putString("data_2c", data);
                            se.commit();
                            String data_2c = sharedPreferences.getString("data_2c", "yo");
                            Toast.makeText(MainActivity.this, data_2c, Toast.LENGTH_LONG).show();
                            txt_2c.setText(data_2c);
                            alertDialogAndroid.dismiss();
                            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                        }
                        else{
                            Toast.makeText(MainActivity.this, "EMPTY , Put amount again", Toast.LENGTH_LONG).show();
                        }
                    }
                });

                alertDialogAndroid.show();
                alertDialogAndroid.setCanceledOnTouchOutside(true);
            }
        });
        String data_2c = sharedPreferences.getString("data_2c", "Subject");
        txt_2c.setText(data_2c);



































//ThirdCardView
        //SecondCardView
        final TextView txt3_a= (TextView) findViewById(R.id.textView_3a);
        assert txt3_a != null;
        txt3_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater layoutInflaterAndroid = LayoutInflater.from(c);
                View mView = layoutInflaterAndroid.inflate(R.layout.dialog_entry, null);
                AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(c);
                alertDialogBuilderUserInput.setView(mView);

                final EditText user_Input = (EditText) mView.findViewById(R.id.userInputDialog);
                final AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();

                user_Input.requestFocus();
                final InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);

                Button btn= (Button) mView.findViewById(R.id.button3);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String data = user_Input.getText().toString();
                        if(!user_Input.getText().toString().isEmpty()) {
                            SharedPreferences.Editor se = sharedPreferences.edit();
                            se.putString("data3_a", data);
                            se.commit();
                            String data3_a = sharedPreferences.getString("data3_a", "yo");
                            Toast.makeText(MainActivity.this, data3_a, Toast.LENGTH_LONG).show();
                            txt3_a.setText(data3_a);
                            alertDialogAndroid.dismiss();
                            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                        }
                        else{
                            Toast.makeText(MainActivity.this, "EMPTY , Put amount again", Toast.LENGTH_LONG).show();
                        }
                    }
                });

                alertDialogAndroid.show();
                alertDialogAndroid.setCanceledOnTouchOutside(true);
            }
        });
        String data3_a = sharedPreferences.getString("data3_a", "Year");
        txt3_a.setText(data3_a);
//
        final TextView txt_3b= (TextView) findViewById(R.id.textView_3b);
        assert txt_3b != null;
        txt_3b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater layoutInflaterAndroid = LayoutInflater.from(c);
                View mView = layoutInflaterAndroid.inflate(R.layout.dialog_entry, null);
                AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(c);
                alertDialogBuilderUserInput.setView(mView);

                final EditText user_Input = (EditText) mView.findViewById(R.id.userInputDialog);
                final AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();

                user_Input.requestFocus();
                final InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);

                Button btn= (Button) mView.findViewById(R.id.button3);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String data = user_Input.getText().toString();
                        if(!user_Input.getText().toString().isEmpty()) {
                            SharedPreferences.Editor se = sharedPreferences.edit();
                            se.putString("data_3b", data);
                            se.commit();
                            String data_3b = sharedPreferences.getString("data_3b", "yo");
                            Toast.makeText(MainActivity.this, data_3b, Toast.LENGTH_LONG).show();
                            txt_3b.setText(data_3b);
                            alertDialogAndroid.dismiss();
                            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                        }
                        else{
                            Toast.makeText(MainActivity.this, "EMPTY , Put amount again", Toast.LENGTH_LONG).show();
                        }
                    }
                });

                alertDialogAndroid.show();
                alertDialogAndroid.setCanceledOnTouchOutside(true);
            }
        });
        String data_3b = sharedPreferences.getString("data_3b", "Branch");
        txt_3b.setText(data_3b);
//

        final TextView txt_3c= (TextView) findViewById(R.id.textView_3c);
        assert txt_3c != null;
        txt_3c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater layoutInflaterAndroid = LayoutInflater.from(c);
                View mView = layoutInflaterAndroid.inflate(R.layout.dialog_entry, null);
                AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(c);
                alertDialogBuilderUserInput.setView(mView);

                final EditText user_Input = (EditText) mView.findViewById(R.id.userInputDialog);
                final AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();

                user_Input.requestFocus();
                final InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);

                Button btn= (Button) mView.findViewById(R.id.button3);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String data = user_Input.getText().toString();
                        if(!user_Input.getText().toString().isEmpty()) {
                            SharedPreferences.Editor se = sharedPreferences.edit();
                            se.putString("data_3c", data);
                            se.commit();
                            String data_3c = sharedPreferences.getString("data_3c", "yo");
                            Toast.makeText(MainActivity.this, data_3c, Toast.LENGTH_LONG).show();
                            txt_3c.setText(data_3c);
                            alertDialogAndroid.dismiss();
                            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                        }
                        else{
                            Toast.makeText(MainActivity.this, "EMPTY , Put amount again", Toast.LENGTH_LONG).show();
                        }
                    }
                });

                alertDialogAndroid.show();
                alertDialogAndroid.setCanceledOnTouchOutside(true);
            }
        });
        String data_3c = sharedPreferences.getString("data_3c", "Subject");
        txt_3c.setText(data_3c);









































//FourthCardView
        final TextView txt4_a= (TextView) findViewById(R.id.textView_4a);
        assert txt4_a != null;
        txt4_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater layoutInflaterAndroid = LayoutInflater.from(c);
                View mView = layoutInflaterAndroid.inflate(R.layout.dialog_entry, null);
                AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(c);
                alertDialogBuilderUserInput.setView(mView);

                final EditText user_Input = (EditText) mView.findViewById(R.id.userInputDialog);
                final AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();

                user_Input.requestFocus();
                final InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);

                Button btn= (Button) mView.findViewById(R.id.button3);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String data = user_Input.getText().toString();
                        if(!user_Input.getText().toString().isEmpty()) {
                            SharedPreferences.Editor se = sharedPreferences.edit();
                            se.putString("data4_a", data);
                            se.commit();
                            String data4_a = sharedPreferences.getString("data4_a", "yo");
                            Toast.makeText(MainActivity.this, data4_a, Toast.LENGTH_LONG).show();
                            txt4_a.setText(data4_a);
                            alertDialogAndroid.dismiss();
                            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                        }
                        else{
                            Toast.makeText(MainActivity.this, "EMPTY , Put amount again", Toast.LENGTH_LONG).show();
                        }
                    }
                });

                alertDialogAndroid.show();
                alertDialogAndroid.setCanceledOnTouchOutside(true);
            }
        });
        String data4_a = sharedPreferences.getString("data4_a", "Year");
        txt4_a.setText(data4_a);
//
        final TextView txt_4b= (TextView) findViewById(R.id.textView_4b);
        assert txt_4b != null;
        txt_4b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater layoutInflaterAndroid = LayoutInflater.from(c);
                View mView = layoutInflaterAndroid.inflate(R.layout.dialog_entry, null);
                AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(c);
                alertDialogBuilderUserInput.setView(mView);

                final EditText user_Input = (EditText) mView.findViewById(R.id.userInputDialog);
                final AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();

                user_Input.requestFocus();
                final InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);

                Button btn= (Button) mView.findViewById(R.id.button3);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String data = user_Input.getText().toString();
                        if(!user_Input.getText().toString().isEmpty()) {
                            SharedPreferences.Editor se = sharedPreferences.edit();
                            se.putString("data_4b", data);
                            se.commit();
                            String data_4b = sharedPreferences.getString("data_4b", "yo");
                            Toast.makeText(MainActivity.this, data_4b, Toast.LENGTH_LONG).show();
                            txt_4b.setText(data_4b);
                            alertDialogAndroid.dismiss();
                            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                        }
                        else{
                            Toast.makeText(MainActivity.this, "EMPTY , Put amount again", Toast.LENGTH_LONG).show();
                        }
                    }
                });

                alertDialogAndroid.show();
                alertDialogAndroid.setCanceledOnTouchOutside(true);
            }
        });
        String data_4b = sharedPreferences.getString("data_4b", "Branch");
        txt_4b.setText(data_4b);
//

        final TextView txt_4c= (TextView) findViewById(R.id.textView_4c);
        assert txt_4c != null;
        txt_4c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater layoutInflaterAndroid = LayoutInflater.from(c);
                View mView = layoutInflaterAndroid.inflate(R.layout.dialog_entry, null);
                AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(c);
                alertDialogBuilderUserInput.setView(mView);

                final EditText user_Input = (EditText) mView.findViewById(R.id.userInputDialog);
                final AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();

                user_Input.requestFocus();
                final InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);

                Button btn= (Button) mView.findViewById(R.id.button3);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String data = user_Input.getText().toString();
                        if(!user_Input.getText().toString().isEmpty()) {
                            SharedPreferences.Editor se = sharedPreferences.edit();
                            se.putString("data_4c", data);
                            se.commit();
                            String data_4c = sharedPreferences.getString("data_4c", "yo");
                            Toast.makeText(MainActivity.this, data_4c, Toast.LENGTH_LONG).show();
                            txt_4c.setText(data_4c);
                            alertDialogAndroid.dismiss();
                            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                        }
                        else{
                            Toast.makeText(MainActivity.this, "EMPTY , Put amount again", Toast.LENGTH_LONG).show();
                        }
                    }
                });

                alertDialogAndroid.show();
                alertDialogAndroid.setCanceledOnTouchOutside(true);
            }
        });
        final String data_4c = sharedPreferences.getString("data_4c", "Subject");
        txt_4c.setText(data_4c);






    }




















































































    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.signin) {


            LayoutInflater layoutInflaterAndroid = LayoutInflater.from(c);
            View mView = layoutInflaterAndroid.inflate(R.layout.dialog_signin, null);
            AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(c);
            alertDialogBuilderUserInput.setView(mView);

            final EditText user_Input = (EditText) mView.findViewById(R.id.header_dialog);
            final AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();

            user_Input.requestFocus();
            final InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);

            Button btn= (Button) mView.findViewById(R.id.button3);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String data = user_Input.getText().toString();
                    if(!user_Input.getText().toString().isEmpty()) {
                        SharedPreferences.Editor se = sharedPreferences.edit();
                        se.putString("data_signin", data);
                        se.commit();
                        String data_signin = sharedPreferences.getString("data_signin", "Sign In");
                        header.setText(data_signin);
                        alertDialogAndroid.dismiss();
                        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "EMPTY , Put amount again", Toast.LENGTH_LONG).show();
                    }
                }
            });

            alertDialogAndroid.show();
            alertDialogAndroid.setCanceledOnTouchOutside(true);
        } else if (id == R.id.nav_home) {
            Intent intent = getIntent();
            finish();
            startActivity(intent);

        }else if (id == R.id.nav_share) {
            Intent i=new Intent(android.content.Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(android.content.Intent.EXTRA_SUBJECT,"Subject test");
            i.putExtra(android.content.Intent.EXTRA_TEXT, "link here");
            startActivity(Intent.createChooser(i,"Share via"));

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
