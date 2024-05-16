package com.example.beautycare;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BeetyFragment extends Fragment {

    private RecyclerView recyclerView;
    private ChatAdapter adapter;
    private List<Message> messageList;
    private EditText editTextMessage;
    private ImageButton buttonSend;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_beety, container, false);

        // Initialize views
        recyclerView = view.findViewById(R.id.recycler_view_chat);
        editTextMessage = view.findViewById(R.id.edit_text_message);
        buttonSend = view.findViewById(R.id.button_send);

        // Initialize message list
        messageList = new ArrayList<>();

        // Initialize adapter and set it to the RecyclerView
        adapter = new ChatAdapter(messageList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Button click listener to send message
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });

        return view;
    }

    // Método para enviar un mensaje
    private void sendMessage() {
        String messageText = editTextMessage.getText().toString().trim();
        if (!messageText.isEmpty()) {
            // Create a new Message object with the user's message
            Message message = new Message(messageText, true);
            // Add the message to the list
            messageList.add(message);
            // Notify the adapter that a new message has been added
            adapter.notifyItemInserted(messageList.size() - 1);
            // Scroll to the bottom of the RecyclerView to show the new message
            recyclerView.scrollToPosition(messageList.size() - 1);
            // Clear the input field
            editTextMessage.setText("");

            // Procesar el mensaje del usuario y enviar una respuesta del bot
            processUserMessage(messageText);
        } else {
            // Si el campo de entrada está vacío, mostrar un mensaje Toast
            Toast.makeText(getContext(), "Por favor, ingresa un mensaje", Toast.LENGTH_SHORT).show();
        }
    }

    // Método para procesar el mensaje del usuario y enviar una respuesta del bot
    private void processUserMessage(String messageText) {
        // Convertir el mensaje del usuario a minúsculas para facilitar la comparación
        String lowercaseMessage = messageText.toLowerCase();
        // Lógica condicional para determinar la respuesta del bot basada en el mensaje del usuario
        String botReply;
        if (lowercaseMessage.contains("belleza")) {
            botReply = "La belleza es una parte importante de nuestra vida. ¿Hay algo específico en lo que te gustaría enfocarte?";
        } else if (lowercaseMessage.contains("hola")) {
                botReply = "¡Hola! ¿En qué puedo ayudarte?";
        } else if (lowercaseMessage.contains("adiós")) {
            botReply = "¡Adiós! Espero verte pronto.";
        } else if (lowercaseMessage.contains("productos para el cabello")) {
            botReply = "Tenemos una amplia variedad de productos para el cabello. ¿Estás buscando algo en particular?";
        } else if (lowercaseMessage.contains("cuidado facial")) {
            botReply = "Para el cuidado facial, recomendamos nuestros productos de limpieza e hidratación. ¿Te gustaría conocer más detalles?";
        } else if (lowercaseMessage.contains("descuentos")) {
            botReply = "¡Claro! Hoy tenemos descuentos en productos seleccionados. ¿Te gustaría saber más?";
        } else if (lowercaseMessage.contains("corte de cabello")) {
            botReply = "Actualmente estamos trabajando en brindar recomendaciones personalizadas para cortes de cabello. ¿Te puedo ayudar con algo más?";
        } else if (lowercaseMessage.contains("barba")) {
            botReply = "¡Entiendo! En este momento estamos desarrollando funciones relacionadas con el cuidado de la barba. ¿Hay algo más en lo que pueda asistirte?";
        } else if (lowercaseMessage.contains("cuidado personal")) {
            botReply = "El cuidado personal es fundamental para sentirnos bien con nosotros mismos. ¿En qué puedo asistirte?";
        } else if (lowercaseMessage.contains("maquillaje")) {
            botReply = "Contamos con una variedad de productos de maquillaje para diferentes estilos y ocasiones. ¿Te gustaría recibir recomendaciones?";
        } else if (lowercaseMessage.contains("crema hidratante")) {
            botReply = "Una buena crema hidratante es esencial para mantener la piel saludable. ¿Tienes algún tipo de piel específico?";
        } else if (lowercaseMessage.contains("protector solar")) {
            botReply = "Es importante proteger la piel del sol. ¿Necesitas un protector solar para el rostro o para el cuerpo?";
        } else if (lowercaseMessage.contains("cuidado del cabello")) {
            botReply = "El cabello es una parte importante de nuestra apariencia. ¿Qué tipo de cuidado estás buscando?";
        } else if (lowercaseMessage.contains("mascarilla facial")) {
            botReply = "Las mascarillas faciales pueden brindar muchos beneficios a la piel. ¿Qué tipo de mascarilla te gustaría probar?";
        } else if (lowercaseMessage.contains("acné")) {
            botReply = "El acné puede ser frustrante, pero contamos con productos efectivos para tratarlo. ¿Te gustaría conocer nuestras opciones?";
        } else if (lowercaseMessage.contains("antiedad")) {
            botReply = "El cuidado antiedad es importante para mantener una piel joven y radiante. ¿Estás buscando algún producto en particular?";
        } else if (lowercaseMessage.contains("exfoliante")) {
            botReply = "La exfoliación es clave para una piel suave y renovada. ¿Necesitas recomendaciones sobre exfoliantes?";
        } else if (lowercaseMessage.contains("fragancias")) {
            botReply = "Tenemos una amplia selección de fragancias para diferentes gustos. ¿Te gustaría encontrar una fragancia que se adapte a ti?";
        } else if (lowercaseMessage.contains("depilación")) {
            botReply = "La depilación es parte del cuidado personal. ¿Necesitas ayuda con algún método de depilación en particular?";
        } else if (lowercaseMessage.contains("uñas")) {
            botReply = "El cuidado de las uñas es importante para mantenerlas sanas y bonitas. ¿Hay algo específico que te gustaría saber?";
        } else if (lowercaseMessage.contains("cabello rizado")) {
            botReply = "El cabello rizado necesita cuidados especiales para mantenerse definido y sin frizz. ¿Necesitas recomendaciones?";
        } else if (lowercaseMessage.contains("cabello liso")) {
            botReply = "El cabello liso también requiere cuidados específicos para mantener su suavidad y brillo. ¿Puedo ayudarte con algo más?";
        } else if (lowercaseMessage.contains("puntas abiertas")) {
            botReply = "Las puntas abiertas son comunes, pero se pueden prevenir con productos específicos y recortes regulares. ¿Te gustaría saber más?";
        } else if (lowercaseMessage.contains("cuidado nocturno")) {
            botReply = "El cuidado nocturno es importante para permitir que la piel se recupere durante la noche. ¿Necesitas recomendaciones?";
        } else if (lowercaseMessage.contains("mascarilla capilar")) {
            botReply = "Las mascarillas capilares son ideales para hidratar y reparar el cabello. ¿Qué tipo de mascarilla estás buscando?";
        } else if (lowercaseMessage.contains("cabello teñido")) {
            botReply = "El cabello teñido necesita cuidados especiales para mantener el color vibrante y la salud del cabello. ¿Te gustaría saber más?";
        } else if (lowercaseMessage.contains("manos y pies")) {
            botReply = "El cuidado de las manos y los pies es esencial para mantener su aspecto y salud. ¿Qué necesitas saber?";
        } else if (lowercaseMessage.contains("piel sensible")) {
            botReply = "La piel sensible requiere productos suaves y sin fragancia para evitar irritaciones. ¿Te gustaría recibir recomendaciones?";
        } else if (lowercaseMessage.contains("bolsas bajo los ojos")) {
            botReply = "Las bolsas bajo los ojos pueden ser un signo de fatiga o retención de líquidos. ¿Quieres saber cómo reducirlas?";
        } else if (lowercaseMessage.contains("máscara de pestañas")) {
            botReply = "Las máscaras de pestañas son ideales para dar volumen y longitud a las pestañas. ¿Buscas una máscara resistente al agua?";
        } else if (lowercaseMessage.contains("manchas en la piel")) {
            botReply = "Las manchas en la piel pueden tratarse con productos específicos y protección solar. ¿Te gustaría conocer nuestras opciones?";
        } else if (lowercaseMessage.contains("brillo labial")) {
            botReply = "Los brillos labiales agregan un toque de color y brillo a tus labios. ¿Te gustaría encontrar el tono perfecto?";
        } else if (lowercaseMessage.contains("rutina de cuidado")) {
            botReply = "Una buena rutina de cuidado es fundamental para mantener la piel sana y radiante. ¿Te gustaría conocer una rutina personalizada?";
        } else if (lowercaseMessage.contains("estrés")) {
            botReply = "El estrés puede afectar la piel y el cabello. ¿Necesitas consejos para manejar el estrés y sus efectos en la belleza?";
        } else if (lowercaseMessage.contains("cuidado masculino")) {
            botReply = "El cuidado masculino es importante para mantener una apariencia fresca y saludable. ¿En qué puedo ayudarte?";
        } else if (lowercaseMessage.contains("regalos")) {
            botReply = "Contamos con una selección de regalos ideales para cualquier ocasión. ¿Necesitas ayuda para encontrar el regalo perfecto?";
        } else if (lowercaseMessage.contains("máscara de arcilla")) {
            botReply = "Las mascarillas de arcilla son excelentes para purificar la piel y controlar el exceso de grasa. ¿Te gustaría probar una?";
        } else if (lowercaseMessage.contains("nutrición de la piel")) {
            botReply = "La nutrición de la piel es importante para mantenerla saludable y radiante. ¿Te gustaría recibir recomendaciones de productos?";
        } else if (lowercaseMessage.contains("cuidado del cuero cabelludo")) {
            botReply = "El cuidado del cuero cabelludo es esencial para un cabello sano y fuerte. ¿Necesitas recomendaciones para el cuidado del cuero cabelludo?";
        } else if (lowercaseMessage.contains("esmalte de uñas")) {
            botReply = "Tenemos una variedad de esmaltes de uñas en diferentes colores y acabados. ¿Cuál es tu tono favorito?";
        } else if (lowercaseMessage.contains("puntos negros")) {
            botReply = "Los puntos negros pueden tratarse con limpieza facial regular y productos específicos. ¿Necesitas recomendaciones?";
        } else if (lowercaseMessage.contains("peinados")) {
            botReply = "Los peinados pueden cambiar por completo tu apariencia. ¿Estás buscando ideas para un nuevo peinado?";
        } else if (lowercaseMessage.contains("hidratación corporal")) {
            botReply = "La hidratación corporal es importante para mantener la piel suave y flexible. ¿Te gustaría recibir recomendaciones de productos?";
        } else if (lowercaseMessage.contains("cabello dañado")) {
            botReply = "El cabello dañado puede recuperarse con productos reparadores y cuidados especiales. ¿Necesitas ayuda?";
        } else if (lowercaseMessage.contains("exceso de grasa")) {
            botReply = "El exceso de grasa en la piel puede tratarse con limpieza facial regular y productos específicos. ¿Te gustaría saber más?";
        } else if (lowercaseMessage.contains("pérdida de cabello")) {
            botReply = "La pérdida de cabello puede ser preocupante, pero existen tratamientos efectivos disponibles. ¿Necesitas asesoramiento?";
        } else if (lowercaseMessage.contains("desodorante")) {
            botReply = "Tenemos una variedad de desodorantes para ayudarte a mantenerte fresco y seco todo el día. ¿Te gustaría encontrar el adecuado?";
        } else if (lowercaseMessage.contains("maquillaje natural")) {
            botReply = "El maquillaje natural es perfecto para un look fresco y ligero. ¿Necesitas recomendaciones de productos?";
        } else if (lowercaseMessage.contains("cejas")) {
            botReply = "Las cejas enmarcan el rostro y son importantes en el maquillaje. ¿Estás buscando productos para dar forma y definición a tus cejas?";
        } else if (lowercaseMessage.contains("contorno")) {
            botReply = "El contorno es ideal para resaltar y definir tus rasgos faciales. ¿Te gustaría conocer técnicas de contorneado?";
        } else if (lowercaseMessage.contains("fijador de maquillaje")) {
            botReply = "Un fijador de maquillaje ayuda a que tu maquillaje dure más tiempo y se vea fresco por más tiempo. ¿Te gustaría probar uno?";
        } else if (lowercaseMessage.contains("bronceado")) {
            botReply = "Un bronceado puede darle a tu piel un aspecto dorado y saludable. ¿Te gustaría conocer nuestras opciones de bronceado sin sol?";
        } else if (lowercaseMessage.contains("cabello gris")) {
            botReply = "El cabello gris puede ser una parte hermosa y natural de tu apariencia. ¿Necesitas ayuda para cuidar y mantener tu cabello gris?";
        } else if (lowercaseMessage.contains("cutis")) {
            botReply = "El cutis es el tipo de piel de tu rostro. ¿Necesitas saber qué productos son mejores para tu tipo de cutis?";
        } else if (lowercaseMessage.contains("mascarillas de tela")) {
            botReply = "Las mascarillas de tela son una excelente forma de hidratar la piel y tratar diferentes problemas cutáneos. ¿Te gustaría probar una?";
        } else if (lowercaseMessage.contains("maquillaje resistente al agua")) {
            botReply = "El maquillaje resistente al agua es ideal para eventos al aire libre o días calurosos. ¿Te gustaría encontrar productos resistentes al agua?";
        } else if (lowercaseMessage.contains("manos secas")) {
            botReply = "Las manos secas pueden tratarse con cremas hidratantes y cuidados especiales. ¿Te gustaría recibir recomendaciones?";
        } else if (lowercaseMessage.contains("spa en casa")) {
            botReply = "Un spa en casa es una excelente manera de relajarte y cuidar tu piel y cabello. ¿Necesitas sugerencias para tu spa en casa?";
        } else if (lowercaseMessage.contains("productos veganos")) {
            botReply = "Tenemos una variedad de productos veganos que no contienen ingredientes de origen animal ni se han probado en animales. ¿Te gustaría ver nuestra selección?";
        } else if (lowercaseMessage.contains("productos orgánicos")) {
            botReply = "Los productos orgánicos son una excelente opción para el cuidado de la piel y el cabello. ¿Te gustaría conocer nuestras opciones?";
        } else if (lowercaseMessage.contains("descuentos")) {
            botReply = "Tenemos descuentos especiales en una variedad de productos. ¿Te gustaría saber qué ofertas tenemos hoy?";
        } else if (lowercaseMessage.contains("corte de cabello")) {
            botReply = "Estamos trabajando en agregar la función de recomendaciones de corte de cabello. Mientras tanto, ¿puedo ayudarte con algo más?";
        } else if (lowercaseMessage.contains("barba")) {
            botReply = "¡Nos encanta tu interés en el cuidado de la barba! Actualmente estamos trabajando en ofrecer recomendaciones específicas para el cuidado de la barba. ¿Te gustaría recibir recomendaciones sobre otros productos?";
        } else {
            botReply = "Lo siento, no entendí. ¿Puedes ser más específico?";
        }
        // Simular una demora antes de que el bot responda
        simulateBotReply(botReply);

    }

    // Método para simular una respuesta del bot con demora
    private void simulateBotReply(final String botReply) {
        // Simula una demora de 1 segundo antes de que el bot responda
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Código para simular la respuesta del bot
                // Create a new Message object with the bot's reply
                Message botMessage = new Message(botReply, false);
                // Add the bot's message to the list
                messageList.add(botMessage);
                // Notificar al adaptador que se ha agregado un nuevo mensaje
                adapter.notifyItemInserted(messageList.size() - 1);
                // Desplazarse hasta la parte inferior del RecyclerView para mostrar el mensaje del bot
                recyclerView.scrollToPosition(messageList.size() - 1);
            }
        }, 1000); // Demora de 2 segundos (1000 milisegundos)
    }


}
