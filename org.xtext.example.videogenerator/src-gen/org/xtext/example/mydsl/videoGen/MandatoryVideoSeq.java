/**
 */
package org.xtext.example.mydsl.videoGen;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mandatory Video Seq</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.videoGen.MandatoryVideoSeq#getDescription <em>Description</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.mydsl.videoGen.VideoGenPackage#getMandatoryVideoSeq()
 * @model
 * @generated
 */
public interface MandatoryVideoSeq extends VideoSeq
{
  /**
   * Returns the value of the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Description</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Description</em>' containment reference.
   * @see #setDescription(VideoDescription)
   * @see org.xtext.example.mydsl.videoGen.VideoGenPackage#getMandatoryVideoSeq_Description()
   * @model containment="true"
   * @generated
   */
  VideoDescription getDescription();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.videoGen.MandatoryVideoSeq#getDescription <em>Description</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' containment reference.
   * @see #getDescription()
   * @generated
   */
  void setDescription(VideoDescription value);

} // MandatoryVideoSeq
