package fr.wildcodeschool.roomreservation;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class PersonListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_list);

        ArrayList<PersonModel> personModels = loadPersonsFromDB();

        PersonAdapter adapter = new PersonAdapter(this, 0, personModels);
        ListView lvListPerson = findViewById(R.id.list_person);
        lvListPerson.setAdapter(adapter);
    }

    private ArrayList<PersonModel> loadPersonsFromDB() {
        ArrayList<PersonModel> personModels = new ArrayList<>();

        DbHelper mDbHelper = new DbHelper(PersonListActivity.this);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] projection = {
                DBContact.PersonEntry._ID,
                DBContact.PersonEntry.COLUMN_NAME_FIRSTNAME,
                DBContact.PersonEntry.COLUMN_NAME_LASTNAME
        };

        Cursor cursor = db.query(
                DBContact.PersonEntry.TABLE_NAME,
                projection,
                null, null, null, null, null
        );

        while (cursor.moveToNext()) {
            long id = cursor.getLong(cursor.getColumnIndexOrThrow(DBContact.PersonEntry._ID));
            String firstname = cursor.getString(cursor.getColumnIndexOrThrow(DBContact.PersonEntry.COLUMN_NAME_FIRSTNAME));
            String lastname = cursor.getString(cursor.getColumnIndexOrThrow(DBContact.PersonEntry.COLUMN_NAME_LASTNAME));

            PersonModel personModel = new PersonModel(id, firstname, lastname);
            personModels.add(personModel);
        }
        cursor.close();

        return personModels;
    }
}
