/**
 */
package org.xtext.example.mydsl.videoGen.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.xtext.example.mydsl.videoGen.Subtitle;
import org.xtext.example.mydsl.videoGen.VideoDescription;
import org.xtext.example.mydsl.videoGen.VideoGenPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Video Description</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.videoGen.impl.VideoDescriptionImpl#getVideoid <em>Videoid</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.videoGen.impl.VideoDescriptionImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.videoGen.impl.VideoDescriptionImpl#getDuration <em>Duration</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.videoGen.impl.VideoDescriptionImpl#getProbability <em>Probability</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.videoGen.impl.VideoDescriptionImpl#getSize <em>Size</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.videoGen.impl.VideoDescriptionImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.videoGen.impl.VideoDescriptionImpl#getSubtitle <em>Subtitle</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VideoDescriptionImpl extends MinimalEObjectImpl.Container implements VideoDescription
{
  /**
   * The default value of the '{@link #getVideoid() <em>Videoid</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVideoid()
   * @generated
   * @ordered
   */
  protected static final String VIDEOID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getVideoid() <em>Videoid</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVideoid()
   * @generated
   * @ordered
   */
  protected String videoid = VIDEOID_EDEFAULT;

  /**
   * The default value of the '{@link #getLocation() <em>Location</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLocation()
   * @generated
   * @ordered
   */
  protected static final String LOCATION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getLocation() <em>Location</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLocation()
   * @generated
   * @ordered
   */
  protected String location = LOCATION_EDEFAULT;

  /**
   * The default value of the '{@link #getDuration() <em>Duration</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDuration()
   * @generated
   * @ordered
   */
  protected static final int DURATION_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getDuration() <em>Duration</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDuration()
   * @generated
   * @ordered
   */
  protected int duration = DURATION_EDEFAULT;

  /**
   * The default value of the '{@link #getProbability() <em>Probability</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProbability()
   * @generated
   * @ordered
   */
  protected static final int PROBABILITY_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getProbability() <em>Probability</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProbability()
   * @generated
   * @ordered
   */
  protected int probability = PROBABILITY_EDEFAULT;

  /**
   * The default value of the '{@link #getSize() <em>Size</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSize()
   * @generated
   * @ordered
   */
  protected static final int SIZE_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getSize() <em>Size</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSize()
   * @generated
   * @ordered
   */
  protected int size = SIZE_EDEFAULT;

  /**
   * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected static final String DESCRIPTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected String description = DESCRIPTION_EDEFAULT;

  /**
   * The cached value of the '{@link #getSubtitle() <em>Subtitle</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubtitle()
   * @generated
   * @ordered
   */
  protected Subtitle subtitle;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VideoDescriptionImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return VideoGenPackage.Literals.VIDEO_DESCRIPTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getVideoid()
  {
    return videoid;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVideoid(String newVideoid)
  {
    String oldVideoid = videoid;
    videoid = newVideoid;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VideoGenPackage.VIDEO_DESCRIPTION__VIDEOID, oldVideoid, videoid));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLocation()
  {
    return location;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLocation(String newLocation)
  {
    String oldLocation = location;
    location = newLocation;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VideoGenPackage.VIDEO_DESCRIPTION__LOCATION, oldLocation, location));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getDuration()
  {
    return duration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDuration(int newDuration)
  {
    int oldDuration = duration;
    duration = newDuration;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VideoGenPackage.VIDEO_DESCRIPTION__DURATION, oldDuration, duration));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getProbability()
  {
    return probability;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setProbability(int newProbability)
  {
    int oldProbability = probability;
    probability = newProbability;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VideoGenPackage.VIDEO_DESCRIPTION__PROBABILITY, oldProbability, probability));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getSize()
  {
    return size;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSize(int newSize)
  {
    int oldSize = size;
    size = newSize;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VideoGenPackage.VIDEO_DESCRIPTION__SIZE, oldSize, size));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDescription()
  {
    return description;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDescription(String newDescription)
  {
    String oldDescription = description;
    description = newDescription;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VideoGenPackage.VIDEO_DESCRIPTION__DESCRIPTION, oldDescription, description));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Subtitle getSubtitle()
  {
    return subtitle;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSubtitle(Subtitle newSubtitle, NotificationChain msgs)
  {
    Subtitle oldSubtitle = subtitle;
    subtitle = newSubtitle;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VideoGenPackage.VIDEO_DESCRIPTION__SUBTITLE, oldSubtitle, newSubtitle);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSubtitle(Subtitle newSubtitle)
  {
    if (newSubtitle != subtitle)
    {
      NotificationChain msgs = null;
      if (subtitle != null)
        msgs = ((InternalEObject)subtitle).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VideoGenPackage.VIDEO_DESCRIPTION__SUBTITLE, null, msgs);
      if (newSubtitle != null)
        msgs = ((InternalEObject)newSubtitle).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VideoGenPackage.VIDEO_DESCRIPTION__SUBTITLE, null, msgs);
      msgs = basicSetSubtitle(newSubtitle, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VideoGenPackage.VIDEO_DESCRIPTION__SUBTITLE, newSubtitle, newSubtitle));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case VideoGenPackage.VIDEO_DESCRIPTION__SUBTITLE:
        return basicSetSubtitle(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case VideoGenPackage.VIDEO_DESCRIPTION__VIDEOID:
        return getVideoid();
      case VideoGenPackage.VIDEO_DESCRIPTION__LOCATION:
        return getLocation();
      case VideoGenPackage.VIDEO_DESCRIPTION__DURATION:
        return getDuration();
      case VideoGenPackage.VIDEO_DESCRIPTION__PROBABILITY:
        return getProbability();
      case VideoGenPackage.VIDEO_DESCRIPTION__SIZE:
        return getSize();
      case VideoGenPackage.VIDEO_DESCRIPTION__DESCRIPTION:
        return getDescription();
      case VideoGenPackage.VIDEO_DESCRIPTION__SUBTITLE:
        return getSubtitle();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case VideoGenPackage.VIDEO_DESCRIPTION__VIDEOID:
        setVideoid((String)newValue);
        return;
      case VideoGenPackage.VIDEO_DESCRIPTION__LOCATION:
        setLocation((String)newValue);
        return;
      case VideoGenPackage.VIDEO_DESCRIPTION__DURATION:
        setDuration((Integer)newValue);
        return;
      case VideoGenPackage.VIDEO_DESCRIPTION__PROBABILITY:
        setProbability((Integer)newValue);
        return;
      case VideoGenPackage.VIDEO_DESCRIPTION__SIZE:
        setSize((Integer)newValue);
        return;
      case VideoGenPackage.VIDEO_DESCRIPTION__DESCRIPTION:
        setDescription((String)newValue);
        return;
      case VideoGenPackage.VIDEO_DESCRIPTION__SUBTITLE:
        setSubtitle((Subtitle)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case VideoGenPackage.VIDEO_DESCRIPTION__VIDEOID:
        setVideoid(VIDEOID_EDEFAULT);
        return;
      case VideoGenPackage.VIDEO_DESCRIPTION__LOCATION:
        setLocation(LOCATION_EDEFAULT);
        return;
      case VideoGenPackage.VIDEO_DESCRIPTION__DURATION:
        setDuration(DURATION_EDEFAULT);
        return;
      case VideoGenPackage.VIDEO_DESCRIPTION__PROBABILITY:
        setProbability(PROBABILITY_EDEFAULT);
        return;
      case VideoGenPackage.VIDEO_DESCRIPTION__SIZE:
        setSize(SIZE_EDEFAULT);
        return;
      case VideoGenPackage.VIDEO_DESCRIPTION__DESCRIPTION:
        setDescription(DESCRIPTION_EDEFAULT);
        return;
      case VideoGenPackage.VIDEO_DESCRIPTION__SUBTITLE:
        setSubtitle((Subtitle)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case VideoGenPackage.VIDEO_DESCRIPTION__VIDEOID:
        return VIDEOID_EDEFAULT == null ? videoid != null : !VIDEOID_EDEFAULT.equals(videoid);
      case VideoGenPackage.VIDEO_DESCRIPTION__LOCATION:
        return LOCATION_EDEFAULT == null ? location != null : !LOCATION_EDEFAULT.equals(location);
      case VideoGenPackage.VIDEO_DESCRIPTION__DURATION:
        return duration != DURATION_EDEFAULT;
      case VideoGenPackage.VIDEO_DESCRIPTION__PROBABILITY:
        return probability != PROBABILITY_EDEFAULT;
      case VideoGenPackage.VIDEO_DESCRIPTION__SIZE:
        return size != SIZE_EDEFAULT;
      case VideoGenPackage.VIDEO_DESCRIPTION__DESCRIPTION:
        return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
      case VideoGenPackage.VIDEO_DESCRIPTION__SUBTITLE:
        return subtitle != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (videoid: ");
    result.append(videoid);
    result.append(", location: ");
    result.append(location);
    result.append(", duration: ");
    result.append(duration);
    result.append(", probability: ");
    result.append(probability);
    result.append(", size: ");
    result.append(size);
    result.append(", description: ");
    result.append(description);
    result.append(')');
    return result.toString();
  }

} //VideoDescriptionImpl
