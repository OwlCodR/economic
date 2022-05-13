/*
    Copyright © 2018 OwlCodR
    https://github.com/OwlCodR
*/


package com.economic.economic;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class FragmentEcoGetInfo extends Fragment implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {

    RadioButton radioButtonCredit, radioButtonCreditDiff, radioButtonCreditAnnuity, radioButtonDeposit,
            radioButtonPeriods, radioButtonPercents, radioButtonSumStart, radioButtonProfit;
    EditText editTextPeriods, editTextPercents, editTextSumStart, editTextSumEnd, editTextProfit;
    TextInputLayout textInputLayoutPeriods, textInputLayoutPercents, textInputLayoutSumStart, textInputLayoutSumEnd, textInputLayoutProfit;
    RadioGroup radioGroupTaskType, radioGroupCreditType, radioGroupFindType;
    Button buttonResult;
    ImageView imageViewDelete;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflateView = View.inflate(getActivity(), R.layout.fragment_fragment_eco_get_info, null);
        radioGroupTaskType = (RadioGroup) inflateView.findViewById(R.id.radioGroupTaskType);
        radioGroupFindType = (RadioGroup) inflateView.findViewById(R.id.radioGroupFindType);
        radioGroupCreditType = (RadioGroup) inflateView.findViewById(R.id.radioGroupCreditTypes);
        radioGroupTaskType.setOnCheckedChangeListener(this);
        radioGroupFindType.setOnCheckedChangeListener(this);
        radioGroupCreditType.setOnCheckedChangeListener(this);
        buttonResult = inflateView.findViewById(R.id.buttonResult);
        buttonResult.setOnClickListener(this);

        editTextPeriods = (EditText) inflateView.findViewById(R.id.editTextPeriods);
        editTextPercents = (EditText) inflateView.findViewById(R.id.editTextPercents);
        editTextSumStart = (EditText) inflateView.findViewById(R.id.editTextSumStart);
        editTextSumEnd = (EditText) inflateView.findViewById(R.id.editTextSumEnd);
        editTextProfit = (EditText) inflateView.findViewById(R.id.editTextProfit);

        editTextPeriods.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        editTextPercents.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        editTextSumStart.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        editTextSumEnd.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        editTextProfit.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);

        radioButtonPeriods = (RadioButton) inflateView.findViewById(R.id.radioButtonPeriods);
        radioButtonPercents = (RadioButton) inflateView.findViewById(R.id.radioButtonPercents);
        radioButtonSumStart = (RadioButton) inflateView.findViewById(R.id.radioButtonSumStart);
        radioButtonProfit = (RadioButton) inflateView.findViewById(R.id.radioButtonProfit);

        radioButtonCreditDiff = (RadioButton) inflateView.findViewById(R.id.radioButtonCreditDiff);
        radioButtonCreditAnnuity = (RadioButton) inflateView.findViewById(R.id.radioButtonCreditAnnuity);
        radioButtonDeposit = (RadioButton) inflateView.findViewById(R.id.radioButtonDeposit);
        radioButtonCredit = (RadioButton) inflateView.findViewById(R.id.radioButtonCredit);

        textInputLayoutPeriods = (TextInputLayout) inflateView.findViewById(R.id.textInputLayoutPeriods);
        textInputLayoutPercents = (TextInputLayout) inflateView.findViewById(R.id.textInputLayoutPercents);
        textInputLayoutSumStart = (TextInputLayout) inflateView.findViewById(R.id.textInputLayoutSumStart);
        textInputLayoutSumEnd = (TextInputLayout) inflateView.findViewById(R.id.textInputLayoutSumEnd);
        textInputLayoutProfit = (TextInputLayout) inflateView.findViewById(R.id.textInputLayoutProfit);

        imageViewDelete = inflateView.findViewById(R.id.imageViewDelete);
        imageViewDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextPeriods.setText("");
                editTextPercents.setText("");
                editTextSumStart.setText("");
                editTextSumEnd.setText("");
                editTextProfit.setText("");
            }
        });

        return inflateView;
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            // Тип задачи:
            case R.id.radioButtonCredit:
            {
                if (radioButtonCredit.isChecked()) {
                    radioGroupCreditType.setVisibility(View.VISIBLE);
                    radioButtonProfit.setVisibility(View.GONE);
                    textInputLayoutProfit.setVisibility(View.GONE);
                    radioButtonPeriods.setVisibility(View.VISIBLE);
                    radioGroupCreditType.clearCheck();

                    textInputLayoutSumStart.setHint("Сумма кредита");
                    radioButtonSumStart.setText("Сумма кредита");
                    textInputLayoutSumEnd.setHint("Сумма выплат");
                    textInputLayoutPeriods.setHint("Кол-во платёжных периодов");
                    radioButtonPeriods.setText(getResources().getText(R.string.periods));
                    textInputLayoutPercents.setHint("Процентная ставка");

                    radioGroupFindType.clearCheck();
                    clearTextInputLayoutsErrors();

                    buttonResult.setEnabled(true);
                    //Toast.makeText(getActivity(), "radioButtonCredit", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case R.id.radioButtonCreditDiff:
            {
                if (radioButtonCreditDiff.isChecked()) {
                    radioButtonProfit.setVisibility(View.GONE);
                    textInputLayoutProfit.setVisibility(View.GONE);
                    radioButtonPeriods.setVisibility(View.VISIBLE);

                    radioGroupFindType.clearCheck();
                    clearTextInputLayoutsErrors();

                    buttonResult.setEnabled(true);
                    //Toast.makeText(getActivity(), "radioButtonCreditDiff", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case R.id.radioButtonCreditAnnuity:
            {
                if (radioButtonCreditAnnuity.isChecked()) {
                    radioButtonProfit.setVisibility(View.GONE);
                    textInputLayoutProfit.setVisibility(View.GONE);
                    radioButtonPeriods.setVisibility(View.VISIBLE);

                    radioGroupFindType.clearCheck();
                    clearTextInputLayoutsErrors();

                    buttonResult.setEnabled(true);
                    //Toast.makeText(getActivity(), "radioButtonCreditAnnuity", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case R.id.radioButtonDeposit: {
                if (radioButtonDeposit.isChecked()) {
                    radioGroupCreditType.setVisibility(View.GONE);
                    radioButtonProfit.setVisibility(View.VISIBLE);
                    textInputLayoutProfit.setVisibility(View.VISIBLE);

                    textInputLayoutSumStart.setHint("Сумма вклада");
                    radioButtonSumStart.setText("Сумма вклада");

                    textInputLayoutSumEnd.setHint("Итоговая сумма");

                    textInputLayoutPeriods.setHint("Кол-во начислений");
                    radioButtonPeriods.setText("Количество начислений");

                    textInputLayoutPercents.setHint("Процентная ставка");

                    radioGroupFindType.clearCheck();
                    clearTextInputLayoutsErrors();

                    buttonResult.setEnabled(true);
                    //Toast.makeText(getActivity(), "radioButtonDeposit", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            // Что найти?
            case R.id.radioButtonSumStart:
            {
                if (radioButtonSumStart.isChecked()) {
                    textInputLayoutSumStart.setVisibility(View.GONE);
                    textInputLayoutPercents.setVisibility(View.VISIBLE);
                    textInputLayoutPeriods.setVisibility(View.VISIBLE);
                    clearTextInputLayoutsErrors();

                    if (radioButtonDeposit.isChecked()) {
                        textInputLayoutProfit.setVisibility(View.VISIBLE);
                    } else textInputLayoutPeriods.setVisibility(View.VISIBLE);
                }
                break;
            }
            case R.id.radioButtonPeriods:
            {
                if (radioButtonPeriods.isChecked()) {
                    textInputLayoutPeriods.setVisibility(View.GONE);
                    textInputLayoutSumStart.setVisibility(View.VISIBLE);
                    textInputLayoutPercents.setVisibility(View.VISIBLE);
                    clearTextInputLayoutsErrors();

                    if (radioButtonDeposit.isChecked())
                        textInputLayoutProfit.setVisibility(View.VISIBLE);
                }
                break;
            }
            case R.id.radioButtonPercents:
            {
                if (radioButtonPercents.isChecked()) {
                    textInputLayoutPercents.setVisibility(View.GONE);
                    textInputLayoutPeriods.setVisibility(View.VISIBLE);
                    textInputLayoutSumStart.setVisibility(View.VISIBLE);
                    clearTextInputLayoutsErrors();

                    if (radioButtonDeposit.isChecked()) {
                        textInputLayoutProfit.setVisibility(View.VISIBLE);
                    } else textInputLayoutPeriods.setVisibility(View.VISIBLE);
                }
                break;
            }
            case R.id.radioButtonProfit:
            {
                if (radioButtonProfit.isChecked()) {
                    textInputLayoutProfit.setVisibility(View.GONE);
                    textInputLayoutSumStart.setVisibility(View.VISIBLE);
                    textInputLayoutPercents.setVisibility(View.VISIBLE);
                    textInputLayoutPeriods.setVisibility(View.VISIBLE);
                    clearTextInputLayoutsErrors();
                }
                break;
            }
        }
    }

    @Override
    public void onClick(View view) {
        double sumStart;
        double sumEnd;
        double periods;
        double percents;
        double answer = 0.0;
        try {
            if (radioButtonDeposit.isChecked()) {
                if (radioButtonSumStart.isChecked()) {
                    checkError(textInputLayoutSumEnd);
                    checkError(textInputLayoutPercents);
                    checkError(textInputLayoutPeriods);

                    if (checkError(textInputLayoutSumEnd) && checkError(textInputLayoutPercents) && checkError(textInputLayoutPeriods)) {
                        sumEnd = Double.parseDouble(editTextSumEnd.getText().toString());
                        percents = Double.parseDouble(editTextPercents.getText().toString());
                        periods = Double.parseDouble(editTextPeriods.getText().toString());

                        answer = sumEnd / Math.pow(1 + percents / 100, periods);
                        answer = ((double) Math.round(answer * 100)) / 100;

                        Log.i("MY_LOG", "Депозит - Начальная сумма");
                    }
                }

                if (radioButtonPeriods.isChecked()) {
                    checkError(textInputLayoutSumEnd);
                    checkError(textInputLayoutSumStart);
                    checkError(textInputLayoutPercents);

                    if (checkError(textInputLayoutSumEnd) && checkError(textInputLayoutSumStart) && checkError(textInputLayoutPercents)) {
                        sumEnd = Double.parseDouble(editTextSumEnd.getText().toString());
                        sumStart = Double.parseDouble(editTextSumStart.getText().toString());
                        percents = Double.parseDouble(editTextPercents.getText().toString());
                        for (int i = 0; sumStart * Math.pow(1 + percents / 100, i) <= sumEnd; i++)
                            answer = i;

                        Log.i("MY_LOG", "Депозит - Период");
                    }
                }

                if (radioButtonPercents.isChecked()) {
                    checkError(textInputLayoutSumEnd);
                    checkError(textInputLayoutSumStart);
                    checkError(textInputLayoutPeriods);

                    if (checkError(textInputLayoutSumEnd) && checkError(textInputLayoutSumStart) && checkError(textInputLayoutPeriods)) {
                        sumEnd = Double.parseDouble(editTextSumEnd.getText().toString());
                        sumStart = Double.parseDouble(editTextSumStart.getText().toString());
                        periods = Double.parseDouble(editTextPeriods.getText().toString());

                        answer = 100 * Math.pow(sumEnd / sumStart, 1 / periods) - 100;
                        answer = ((double) Math.round(answer * 100)) / 100;

                        Log.i("MY_LOG", "Депозит - Проценты");
                    }
                }
                if (radioButtonProfit.isChecked()) {
                    checkError(textInputLayoutPercents);
                    checkError(textInputLayoutSumStart);
                    checkError(textInputLayoutPeriods);

                    if (checkError(textInputLayoutPercents) && checkError(textInputLayoutSumStart) && checkError(textInputLayoutPeriods)) {
                        percents = Double.parseDouble(editTextPercents.getText().toString());
                        sumStart = Double.parseDouble(editTextSumStart.getText().toString());
                        periods = Double.parseDouble(editTextPeriods.getText().toString());

                        answer = sumStart * Math.pow(1 + percents / 100, periods) - sumStart;
                        answer = ((double) Math.round(answer * 100)) / 100;

                        Log.i("MY_LOG", "Депозит - Прибыль");
                    }
                }
            } else if (radioButtonCreditAnnuity.isChecked()) {
                if (radioButtonSumStart.isChecked()) {
                    checkError(textInputLayoutPercents);
                    checkError(textInputLayoutSumEnd);
                    checkError(textInputLayoutPeriods);

                    if (checkError(textInputLayoutPercents) && checkError(textInputLayoutSumEnd) && checkError(textInputLayoutPeriods)) {
                        percents = Double.parseDouble(editTextPercents.getText().toString());
                        sumEnd = Double.parseDouble(editTextSumEnd.getText().toString());
                        periods = Double.parseDouble(editTextPeriods.getText().toString());

                        double num = Math.pow(1 + percents / 100, periods);
                        answer = sumEnd * (num - 1) / ((periods * num) * (percents / 100));
                        answer = ((double) Math.round(answer * 100)) / 100;

                        Log.i("MY_LOG", "Кредит - Аннуитет - Начальная сумма");
                    }
                }
                if (radioButtonPeriods.isChecked()) {
                    checkError(textInputLayoutSumEnd);
                    checkError(textInputLayoutSumStart);
                    checkError(textInputLayoutPercents);

                    if (checkError(textInputLayoutSumEnd) && checkError(textInputLayoutSumStart) && checkError(textInputLayoutPercents)) {
                        sumEnd = Double.parseDouble(editTextSumEnd.getText().toString());
                        sumStart = Double.parseDouble(editTextSumStart.getText().toString());
                        percents = Double.parseDouble(editTextPercents.getText().toString());

                        double m = 1 + percents / 100;
                        for (int i = 1; i * Math.pow(m, i) * sumStart * (m - 1) / (Math.pow(m, i) - 1) < sumEnd; ++i)
                            answer = i;
                        answer++;
                        answer = ((double) Math.round(answer * 100)) / 100;

                        Log.i("MY_LOG", "Кредит - Аннуитет - Период");
                    }
                }
                if (radioButtonPercents.isChecked()) {
                    checkError(textInputLayoutSumStart);
                    checkError(textInputLayoutSumEnd);
                    checkError(textInputLayoutPeriods);

                    if (checkError(textInputLayoutSumEnd) && checkError(textInputLayoutSumStart) && checkError(textInputLayoutPeriods)) {
                        sumEnd = Double.parseDouble(editTextSumEnd.getText().toString());
                        sumStart = Double.parseDouble(editTextSumStart.getText().toString());
                        periods = Double.parseDouble(editTextPeriods.getText().toString());

                        double k = 0.0;
                        double num;
                        do {
                            k++;
                            num = periods * Math.pow(1 + k / 100, periods) * sumStart * (k / 100) / (Math.pow(1 + k / 100, periods) - 1);
                        }
                        while (num <= sumEnd);
                        if (num != sumEnd) {
                            do {
                                k -= 0.1;
                                num = periods * Math.pow(1 + k / 100, periods) * sumStart * (k / 100) / (Math.pow(1 + k / 100, periods) - 1);
                            }
                            while (num >= sumEnd);
                        }
                        if (num != sumEnd) {
                            do {
                                k += 0.01;
                                num = periods * Math.pow(1 + k / 100, periods) * sumStart * (k / 100) / (Math.pow(1 + k / 100, periods) - 1);
                            }
                            while (num <= sumEnd);
                        }
                        if (num != sumEnd) {
                            do {
                                k -= 0.001;
                                num = periods * Math.pow(1 + k / 100, periods) * sumStart * (k / 100) / (Math.pow(1 + k / 100, periods) - 1);
                            }
                            while (num >= sumEnd);
                        }
                        answer = k;
                        answer = ((double) Math.round(answer * 100)) / 100;

                        Log.i("MY_LOG", "Кредит - Аннуитет - Проценты");
                    }
                }
            } else if (radioButtonCreditDiff.isChecked()) {
                if (radioButtonSumStart.isChecked()) {
                    checkError(textInputLayoutSumEnd);
                    checkError(textInputLayoutPercents);
                    checkError(textInputLayoutPeriods);

                    if (checkError(textInputLayoutSumEnd) && checkError(textInputLayoutPercents) && checkError(textInputLayoutPeriods)) {
                        percents = Double.parseDouble(editTextPercents.getText().toString());
                        sumEnd = Double.parseDouble(editTextSumEnd.getText().toString());
                        periods = Double.parseDouble(editTextPeriods.getText().toString());

                        answer = sumEnd / (1 + percents * (periods + 1) / 200);
                        answer = ((double) Math.round(answer * 100)) / 100;

                        Log.i("MY_LOG", "Кредит - Дифф - Начальная сумма");
                    }
                }
                if (radioButtonPercents.isChecked()) {
                    checkError(textInputLayoutSumStart);
                    checkError(textInputLayoutSumEnd);
                    checkError(textInputLayoutPeriods);

                    if (checkError(textInputLayoutSumStart) && checkError(textInputLayoutSumEnd) && checkError(textInputLayoutPeriods)) {
                        sumEnd = Double.parseDouble(editTextSumEnd.getText().toString());
                        sumStart = Double.parseDouble(editTextSumStart.getText().toString());
                        periods = Double.parseDouble(editTextPeriods.getText().toString());

                        answer = 200 * (sumEnd / sumStart - 1) / (periods + 1);
                        answer = ((double) Math.round(answer * 100)) / 100;

                        Log.i("MY_LOG", "Кредит - Дифф - Проценты");
                    }
                }
                if (radioButtonPeriods.isChecked()) {
                    checkError(textInputLayoutSumStart);
                    checkError(textInputLayoutSumEnd);
                    checkError(textInputLayoutPercents);

                    if (checkError(textInputLayoutSumStart) && checkError(textInputLayoutSumEnd) && checkError(textInputLayoutPercents)) {
                        sumEnd = Double.parseDouble(editTextSumEnd.getText().toString());
                        sumStart = Double.parseDouble(editTextSumStart.getText().toString());
                        percents = Double.parseDouble(editTextPercents.getText().toString());
                        double n = 200 * (sumEnd / sumStart - 1) / percents - 1;
                        answer = Math.floor(n);
                        if (n - Math.floor(n) != 0) {
                            answer++;
                        }
                        answer = ((double) Math.round(answer * 100)) / 100;

                        Log.i("MY_LOG", "Кредит - Дифф - Период");
                    }
                }
            } else Snackbar.make(view, "Выберите тип задачи!", Snackbar.LENGTH_SHORT).show();
            Log.i("MY_LOG", "Ответ: " + answer);
            if (answer != 0.0) {
                if (answer > 0) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle("Рассчеты закончены!")
                            .setMessage("Ответ: " + answer)
                            .setCancelable(false)
                            .setNegativeButton("Ок",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                    AlertDialog alert = builder.create();
                    alert.show();
                } else Snackbar.make(view, "Некорректные значения!\nПроверьте правильность введенных данных!", Snackbar.LENGTH_LONG).show();
            } //else Snackbar.make(view, "Выберите тип задачи и то, что нужно найти!", Snackbar.LENGTH_SHORT).show();
        } catch (NumberFormatException e) {
            Log.e("MY_LOG", e.getMessage() + "\n" + e.getClass());
            /*
            if (e.getMessage().equals("empty String")) {
                Snackbar.make(view, "Недостаточно информации для решения этой задачи!", Snackbar.LENGTH_SHORT).show();
            }
            if (e.getMessage().contains("For input string")) {
                Snackbar.make(view, "Некорректные значения!\nПроверьте правильность введенных данных!", Snackbar.LENGTH_LONG).show();
            }
            */
        } catch (Exception e) {
            Log.e("MY_LOG", e.getMessage() + "\n" + e.getClass());
            Snackbar.make(view, "Некорректные значения!\nПроверьте правильность введенных данных!", Snackbar.LENGTH_LONG).show();
        }
    }

    private void clearTextInputLayoutsErrors() {
        textInputLayoutPeriods.setError(null);
        textInputLayoutSumEnd.setError(null);
        textInputLayoutSumStart.setError(null);
        textInputLayoutProfit.setError(null);
        textInputLayoutPercents.setError(null);
    }
    private boolean checkError(TextInputLayout textInputLayoutInput) {
        if (textInputLayoutInput.getEditText() != null) {
            String input = textInputLayoutInput.getEditText().getText().toString();
            if (input.isEmpty() || input.equals("")) {
                textInputLayoutInput.setError("Заполните поле");
                return false;
            }
            if (Double.parseDouble(input) <= 0.0) {
                textInputLayoutInput.setError("Введите значение, отличное от нуля");
                return false;
            }
            textInputLayoutInput.setError(null);
            return true;
        } else return false;
    }
}

/* TO DO LIST
 1. Изменить дизайн EditText
  */










