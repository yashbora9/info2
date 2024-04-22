from PIL import Image
import numpy as np

def median_cut_quantize(image):
    # Initialisiere Farbbins mit allen Pixeln
    color_bins = [np.array(image).reshape(-1, 3)]
    
    for _ in range(8):  # 8 Iterationen für 8-Bit-Bilder
        new_bins = []
        for color_bin in color_bins:
            # Finde den Kanal mit der größten Spanne
            span = color_bin.max(axis=0) - color_bin.min(axis=0)
            channel = np.argmax(span)
            # Sortiere die Pixel in diesem Bin nach diesem Kanal
            sorted_bin = color_bin[color_bin[:, channel].argsort()]
            # Teile den sortierten Bin in zwei Hälften
            mid = len(sorted_bin) // 2
            new_bins.extend([sorted_bin[:mid], sorted_bin[mid:]])
        color_bins = new_bins
    
    # Berechne die mittlere Farbe jedes Bins
    mean_colors = [np.mean(color_bin, axis=0) for color_bin in color_bins]
    
    # Weise jedem Pixel die nächstgelegene mittlere Farbe zu
    quantized_pixels = np.array([mean_colors[np.argmin(np.sum((pixel - mean_colors)**2, axis=1))] for pixel in np.array(image).reshape(-1, 3)])
    
    # Konvertiere die Pixel zurück in ein Bild
    quantized_image = Image.fromarray(quantized_pixels.reshape(image.size[::-1] + (3,)).astype('uint8'))
    return quantized_image

# Lese das Bild ein
# Fügen Sie hier den Link für die Eingabedatei ein
image = Image.open('/Users/shreysrivastava/Desktop/Bildverarbeitung SS24/sample.jpeg')

# Wandle das Bild um
quantized_image = median_cut_quantize(image)

# Zeige das umgewandelte Bild an
quantized_image.show()

# Speichere das umgewandelte Bild
# Fügen Sie hier den Link für die Ausgabedatei ein
quantized_image.save('/Users/shreysrivastava/Desktop/Bildverarbeitung SS24/neu_image.jpeg')